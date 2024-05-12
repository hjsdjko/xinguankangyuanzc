
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
 * 防护知识
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/fanghuzhishi")
public class FanghuzhishiController {
    private static final Logger logger = LoggerFactory.getLogger(FanghuzhishiController.class);

    private static final String TABLE_NAME = "fanghuzhishi";

    @Autowired
    private FanghuzhishiService fanghuzhishiService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private AddressService addressService;//收货地址
    @Autowired
    private DictionaryService dictionaryService;//字典
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
    private XinguankangyuanService xinguankangyuanService;//新冠抗原
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
        CommonUtil.checkMap(params);
        PageUtils page = fanghuzhishiService.queryPage(params);

        //字典表数据转换
        List<FanghuzhishiView> list =(List<FanghuzhishiView>)page.getList();
        for(FanghuzhishiView c:list){
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
        FanghuzhishiEntity fanghuzhishi = fanghuzhishiService.selectById(id);
        if(fanghuzhishi !=null){
            //entity转view
            FanghuzhishiView view = new FanghuzhishiView();
            BeanUtils.copyProperties( fanghuzhishi , view );//把实体数据重构到view中
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
    public R save(@RequestBody FanghuzhishiEntity fanghuzhishi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,fanghuzhishi:{}",this.getClass().getName(),fanghuzhishi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<FanghuzhishiEntity> queryWrapper = new EntityWrapper<FanghuzhishiEntity>()
            .eq("fanghuzhishi_name", fanghuzhishi.getFanghuzhishiName())
            .eq("fanghuzhishi_types", fanghuzhishi.getFanghuzhishiTypes())
            .eq("fanghuzhishi_video", fanghuzhishi.getFanghuzhishiVideo())
            .eq("zan_number", fanghuzhishi.getZanNumber())
            .eq("cai_number", fanghuzhishi.getCaiNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FanghuzhishiEntity fanghuzhishiEntity = fanghuzhishiService.selectOne(queryWrapper);
        if(fanghuzhishiEntity==null){
            fanghuzhishi.setFanghuzhishiClicknum(1);
            fanghuzhishi.setInsertTime(new Date());
            fanghuzhishi.setCreateTime(new Date());
            fanghuzhishiService.insert(fanghuzhishi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody FanghuzhishiEntity fanghuzhishi, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,fanghuzhishi:{}",this.getClass().getName(),fanghuzhishi.toString());
        FanghuzhishiEntity oldFanghuzhishiEntity = fanghuzhishiService.selectById(fanghuzhishi.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(fanghuzhishi.getFanghuzhishiPhoto()) || "null".equals(fanghuzhishi.getFanghuzhishiPhoto())){
                fanghuzhishi.setFanghuzhishiPhoto(null);
        }
        if("".equals(fanghuzhishi.getFanghuzhishiVideo()) || "null".equals(fanghuzhishi.getFanghuzhishiVideo())){
                fanghuzhishi.setFanghuzhishiVideo(null);
        }

            fanghuzhishiService.updateById(fanghuzhishi);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<FanghuzhishiEntity> oldFanghuzhishiList =fanghuzhishiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        fanghuzhishiService.deleteBatchIds(Arrays.asList(ids));

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
            List<FanghuzhishiEntity> fanghuzhishiList = new ArrayList<>();//上传的东西
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
                            FanghuzhishiEntity fanghuzhishiEntity = new FanghuzhishiEntity();
//                            fanghuzhishiEntity.setFanghuzhishiName(data.get(0));                    //知识标题 要改的
//                            fanghuzhishiEntity.setFanghuzhishiTypes(Integer.valueOf(data.get(0)));   //知识类型 要改的
//                            fanghuzhishiEntity.setFanghuzhishiPhoto("");//详情和图片
//                            fanghuzhishiEntity.setFanghuzhishiVideo(data.get(0));                    //视频 要改的
//                            fanghuzhishiEntity.setZanNumber(Integer.valueOf(data.get(0)));   //赞 要改的
//                            fanghuzhishiEntity.setCaiNumber(Integer.valueOf(data.get(0)));   //踩 要改的
//                            fanghuzhishiEntity.setFanghuzhishiClicknum(Integer.valueOf(data.get(0)));   //点击量 要改的
//                            fanghuzhishiEntity.setInsertTime(date);//时间
//                            fanghuzhishiEntity.setFanghuzhishiContent("");//详情和图片
//                            fanghuzhishiEntity.setCreateTime(date);//时间
                            fanghuzhishiList.add(fanghuzhishiEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        fanghuzhishiService.insertBatch(fanghuzhishiList);
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
        List<FanghuzhishiView> returnFanghuzhishiViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        params1.put("shangxiaTypes",1);
        params1.put("fanghuzhishiYesnoTypes",2);
        PageUtils pageUtils = fanghuzhishiCollectionService.queryPage(params1);
        List<FanghuzhishiCollectionView> collectionViewsList =(List<FanghuzhishiCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(FanghuzhishiCollectionView collectionView:collectionViewsList){
            Integer fanghuzhishiTypes = collectionView.getFanghuzhishiTypes();
            if(typeMap.containsKey(fanghuzhishiTypes)){
                typeMap.put(fanghuzhishiTypes,typeMap.get(fanghuzhishiTypes)+1);
            }else{
                typeMap.put(fanghuzhishiTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("fanghuzhishiTypes",type);
            params2.put("shangxiaTypes",1);
            params2.put("fanghuzhishiYesnoTypes",2);
            PageUtils pageUtils1 = fanghuzhishiService.queryPage(params2);
            List<FanghuzhishiView> fanghuzhishiViewList =(List<FanghuzhishiView>)pageUtils1.getList();
            returnFanghuzhishiViewList.addAll(fanghuzhishiViewList);
            if(returnFanghuzhishiViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        params.put("shangxiaTypes",1);
        params.put("fanghuzhishiYesnoTypes",2);
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = fanghuzhishiService.queryPage(params);
        if(returnFanghuzhishiViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnFanghuzhishiViewList.size();//要添加的数量
            List<FanghuzhishiView> fanghuzhishiViewList =(List<FanghuzhishiView>)page.getList();
            for(FanghuzhishiView fanghuzhishiView:fanghuzhishiViewList){
                Boolean addFlag = true;
                for(FanghuzhishiView returnFanghuzhishiView:returnFanghuzhishiViewList){
                    if(returnFanghuzhishiView.getId().intValue() ==fanghuzhishiView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnFanghuzhishiViewList.add(fanghuzhishiView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnFanghuzhishiViewList = returnFanghuzhishiViewList.subList(0, limit);
        }

        for(FanghuzhishiView c:returnFanghuzhishiViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnFanghuzhishiViewList);
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
        PageUtils page = fanghuzhishiService.queryPage(params);

        //字典表数据转换
        List<FanghuzhishiView> list =(List<FanghuzhishiView>)page.getList();
        for(FanghuzhishiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FanghuzhishiEntity fanghuzhishi = fanghuzhishiService.selectById(id);
            if(fanghuzhishi !=null){

                //点击数量加1
                fanghuzhishi.setFanghuzhishiClicknum(fanghuzhishi.getFanghuzhishiClicknum()+1);
                fanghuzhishiService.updateById(fanghuzhishi);

                //entity转view
                FanghuzhishiView view = new FanghuzhishiView();
                BeanUtils.copyProperties( fanghuzhishi , view );//把实体数据重构到view中

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
    public R add(@RequestBody FanghuzhishiEntity fanghuzhishi, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,fanghuzhishi:{}",this.getClass().getName(),fanghuzhishi.toString());
        Wrapper<FanghuzhishiEntity> queryWrapper = new EntityWrapper<FanghuzhishiEntity>()
            .eq("fanghuzhishi_name", fanghuzhishi.getFanghuzhishiName())
            .eq("fanghuzhishi_types", fanghuzhishi.getFanghuzhishiTypes())
            .eq("fanghuzhishi_video", fanghuzhishi.getFanghuzhishiVideo())
            .eq("zan_number", fanghuzhishi.getZanNumber())
            .eq("cai_number", fanghuzhishi.getCaiNumber())
            .eq("fanghuzhishi_clicknum", fanghuzhishi.getFanghuzhishiClicknum())
//            .notIn("fanghuzhishi_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FanghuzhishiEntity fanghuzhishiEntity = fanghuzhishiService.selectOne(queryWrapper);
        if(fanghuzhishiEntity==null){
                fanghuzhishi.setZanNumber(1);
                fanghuzhishi.setCaiNumber(1);
            fanghuzhishi.setFanghuzhishiClicknum(1);
            fanghuzhishi.setInsertTime(new Date());
            fanghuzhishi.setCreateTime(new Date());
        fanghuzhishiService.insert(fanghuzhishi);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

