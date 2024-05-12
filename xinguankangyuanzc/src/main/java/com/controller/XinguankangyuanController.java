
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 新冠抗原
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xinguankangyuan")
public class XinguankangyuanController {
    private static final Logger logger = LoggerFactory.getLogger(XinguankangyuanController.class);

    private static final String TABLE_NAME = "xinguankangyuan";

    @Autowired
    private XinguankangyuanService xinguankangyuanService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private AddressService addressService;//收货地址
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private FanghuzhishiService fanghuzhishiService;//防护知识
    @Autowired
    private FanghuzhishiCollectionService fanghuzhishiCollectionService;//防护知识收藏
    @Autowired
    private FanghuzhishiLiuyanService fanghuzhishiLiuyanService;//防护知识留言
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private JianceService jianceService;//检测记录
    @Autowired
    private NewsService newsService;//公告通知
    @Autowired
    private XinguankangyuanCollectionService xinguankangyuanCollectionService;//新冠抗原收藏
    @Autowired
    private XinguankangyuanLiuyanService xinguankangyuanLiuyanService;//新冠抗原留言
    @Autowired
    private XinguankangyuanOrderService xinguankangyuanOrderService;//新冠抗原订单
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        params.put("xinguankangyuanDeleteStart",1);params.put("xinguankangyuanDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = xinguankangyuanService.queryPage(params);

        //字典表数据转换
        List<XinguankangyuanView> list =(List<XinguankangyuanView>)page.getList();
        for(XinguankangyuanView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XinguankangyuanEntity xinguankangyuan = xinguankangyuanService.selectById(id);
        if(xinguankangyuan !=null){
            //entity转view
            XinguankangyuanView view = new XinguankangyuanView();
            BeanUtils.copyProperties( xinguankangyuan , view );//把实体数据重构到view中
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody XinguankangyuanEntity xinguankangyuan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xinguankangyuan:{}",this.getClass().getName(),xinguankangyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<XinguankangyuanEntity> queryWrapper = new EntityWrapper<XinguankangyuanEntity>()
            .eq("xinguankangyuan_name", xinguankangyuan.getXinguankangyuanName())
            .eq("xinguankangyuan_types", xinguankangyuan.getXinguankangyuanTypes())
            .eq("xinguankangyuan_kucun_number", xinguankangyuan.getXinguankangyuanKucunNumber())
            .eq("shangxia_types", xinguankangyuan.getShangxiaTypes())
            .eq("xinguankangyuan_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XinguankangyuanEntity xinguankangyuanEntity = xinguankangyuanService.selectOne(queryWrapper);
        if(xinguankangyuanEntity==null){
            xinguankangyuan.setXinguankangyuanClicknum(1);
            xinguankangyuan.setShangxiaTypes(1);
            xinguankangyuan.setXinguankangyuanDelete(1);
            xinguankangyuan.setInsertTime(new Date());
            xinguankangyuan.setCreateTime(new Date());
            xinguankangyuanService.insert(xinguankangyuan);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XinguankangyuanEntity xinguankangyuan, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,xinguankangyuan:{}",this.getClass().getName(),xinguankangyuan.toString());
        XinguankangyuanEntity oldXinguankangyuanEntity = xinguankangyuanService.selectById(xinguankangyuan.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(xinguankangyuan.getXinguankangyuanPhoto()) || "null".equals(xinguankangyuan.getXinguankangyuanPhoto())){
                xinguankangyuan.setXinguankangyuanPhoto(null);
        }

            xinguankangyuanService.updateById(xinguankangyuan);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<XinguankangyuanEntity> oldXinguankangyuanList =xinguankangyuanService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<XinguankangyuanEntity> list = new ArrayList<>();
        for(Integer id:ids){
            XinguankangyuanEntity xinguankangyuanEntity = new XinguankangyuanEntity();
            xinguankangyuanEntity.setId(id);
            xinguankangyuanEntity.setXinguankangyuanDelete(2);
            list.add(xinguankangyuanEntity);
        }
        if(list != null && list.size() >0){
            xinguankangyuanService.updateBatchById(list);
        }

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<XinguankangyuanEntity> xinguankangyuanList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            XinguankangyuanEntity xinguankangyuanEntity = new XinguankangyuanEntity();
//                            xinguankangyuanEntity.setXinguankangyuanUuidNumber(data.get(0));                    //新冠抗原编号 要改的
//                            xinguankangyuanEntity.setXinguankangyuanName(data.get(0));                    //新冠抗原名称 要改的
//                            xinguankangyuanEntity.setXinguankangyuanPhoto("");//详情和图片
//                            xinguankangyuanEntity.setXinguankangyuanTypes(Integer.valueOf(data.get(0)));   //新冠抗原类型 要改的
//                            xinguankangyuanEntity.setXinguankangyuanKucunNumber(Integer.valueOf(data.get(0)));   //新冠抗原库存 要改的
//                            xinguankangyuanEntity.setXinguankangyuanOldMoney(data.get(0));                    //新冠抗原原价 要改的
//                            xinguankangyuanEntity.setXinguankangyuanNewMoney(data.get(0));                    //现价/积分 要改的
//                            xinguankangyuanEntity.setXinguankangyuanClicknum(Integer.valueOf(data.get(0)));   //新冠抗原热度 要改的
//                            xinguankangyuanEntity.setXinguankangyuanContent("");//详情和图片
//                            xinguankangyuanEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            xinguankangyuanEntity.setXinguankangyuanDelete(1);//逻辑删除字段
//                            xinguankangyuanEntity.setInsertTime(date);//时间
//                            xinguankangyuanEntity.setCreateTime(date);//时间
                            xinguankangyuanList.add(xinguankangyuanEntity);


                            //把要查询是否重复的字段放入map中
                                //新冠抗原编号
                                if(seachFields.containsKey("xinguankangyuanUuidNumber")){
                                    List<String> xinguankangyuanUuidNumber = seachFields.get("xinguankangyuanUuidNumber");
                                    xinguankangyuanUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> xinguankangyuanUuidNumber = new ArrayList<>();
                                    xinguankangyuanUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("xinguankangyuanUuidNumber",xinguankangyuanUuidNumber);
                                }
                        }

                        //查询是否重复
                         //新冠抗原编号
                        List<XinguankangyuanEntity> xinguankangyuanEntities_xinguankangyuanUuidNumber = xinguankangyuanService.selectList(new EntityWrapper<XinguankangyuanEntity>().in("xinguankangyuan_uuid_number", seachFields.get("xinguankangyuanUuidNumber")).eq("xinguankangyuan_delete", 1));
                        if(xinguankangyuanEntities_xinguankangyuanUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XinguankangyuanEntity s:xinguankangyuanEntities_xinguankangyuanUuidNumber){
                                repeatFields.add(s.getXinguankangyuanUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [新冠抗原编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        xinguankangyuanService.insertBatch(xinguankangyuanList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }



    /**
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<XinguankangyuanView> returnXinguankangyuanViewList = new ArrayList<>();

        //查询订单
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        params1.put("shangxiaTypes",1);
        params1.put("xinguankangyuanYesnoTypes",2);
        PageUtils pageUtils = xinguankangyuanOrderService.queryPage(params1);
        List<XinguankangyuanOrderView> orderViewsList =(List<XinguankangyuanOrderView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(XinguankangyuanOrderView orderView:orderViewsList){
            Integer xinguankangyuanTypes = orderView.getXinguankangyuanTypes();
            if(typeMap.containsKey(xinguankangyuanTypes)){
                typeMap.put(xinguankangyuanTypes,typeMap.get(xinguankangyuanTypes)+1);
            }else{
                typeMap.put(xinguankangyuanTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("xinguankangyuanTypes",type);
            params2.put("shangxiaTypes",1);
            params2.put("xinguankangyuanYesnoTypes",2);
            PageUtils pageUtils1 = xinguankangyuanService.queryPage(params2);
            List<XinguankangyuanView> xinguankangyuanViewList =(List<XinguankangyuanView>)pageUtils1.getList();
            returnXinguankangyuanViewList.addAll(xinguankangyuanViewList);
            if(returnXinguankangyuanViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        params.put("shangxiaTypes",1);
        params.put("xinguankangyuanYesnoTypes",2);
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = xinguankangyuanService.queryPage(params);
        if(returnXinguankangyuanViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnXinguankangyuanViewList.size();//要添加的数量
            List<XinguankangyuanView> xinguankangyuanViewList =(List<XinguankangyuanView>)page.getList();
            for(XinguankangyuanView xinguankangyuanView:xinguankangyuanViewList){
                Boolean addFlag = true;
                for(XinguankangyuanView returnXinguankangyuanView:returnXinguankangyuanViewList){
                    if(returnXinguankangyuanView.getId().intValue() ==xinguankangyuanView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnXinguankangyuanViewList.add(xinguankangyuanView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnXinguankangyuanViewList = returnXinguankangyuanViewList.subList(0, limit);
        }

        for(XinguankangyuanView c:returnXinguankangyuanViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnXinguankangyuanViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = xinguankangyuanService.queryPage(params);

        //字典表数据转换
        List<XinguankangyuanView> list =(List<XinguankangyuanView>)page.getList();
        for(XinguankangyuanView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XinguankangyuanEntity xinguankangyuan = xinguankangyuanService.selectById(id);
            if(xinguankangyuan !=null){

                //点击数量加1
                xinguankangyuan.setXinguankangyuanClicknum(xinguankangyuan.getXinguankangyuanClicknum()+1);
                xinguankangyuanService.updateById(xinguankangyuan);

                //entity转view
                XinguankangyuanView view = new XinguankangyuanView();
                BeanUtils.copyProperties( xinguankangyuan , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody XinguankangyuanEntity xinguankangyuan, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,xinguankangyuan:{}",this.getClass().getName(),xinguankangyuan.toString());
        Wrapper<XinguankangyuanEntity> queryWrapper = new EntityWrapper<XinguankangyuanEntity>()
            .eq("xinguankangyuan_uuid_number", xinguankangyuan.getXinguankangyuanUuidNumber())
            .eq("xinguankangyuan_name", xinguankangyuan.getXinguankangyuanName())
            .eq("xinguankangyuan_types", xinguankangyuan.getXinguankangyuanTypes())
            .eq("xinguankangyuan_kucun_number", xinguankangyuan.getXinguankangyuanKucunNumber())
            .eq("xinguankangyuan_clicknum", xinguankangyuan.getXinguankangyuanClicknum())
            .eq("shangxia_types", xinguankangyuan.getShangxiaTypes())
            .eq("xinguankangyuan_delete", xinguankangyuan.getXinguankangyuanDelete())
//            .notIn("xinguankangyuan_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XinguankangyuanEntity xinguankangyuanEntity = xinguankangyuanService.selectOne(queryWrapper);
        if(xinguankangyuanEntity==null){
            xinguankangyuan.setXinguankangyuanClicknum(1);
            xinguankangyuan.setXinguankangyuanDelete(1);
            xinguankangyuan.setInsertTime(new Date());
            xinguankangyuan.setCreateTime(new Date());
        xinguankangyuanService.insert(xinguankangyuan);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

