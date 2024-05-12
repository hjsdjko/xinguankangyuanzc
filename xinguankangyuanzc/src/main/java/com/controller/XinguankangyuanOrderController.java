
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
 * 新冠抗原订单
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xinguankangyuanOrder")
public class XinguankangyuanOrderController {
    private static final Logger logger = LoggerFactory.getLogger(XinguankangyuanOrderController.class);

    private static final String TABLE_NAME = "xinguankangyuanOrder";

    @Autowired
    private XinguankangyuanOrderService xinguankangyuanOrderService;


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
    private XinguankangyuanService xinguankangyuanService;//新冠抗原
    @Autowired
    private XinguankangyuanCollectionService xinguankangyuanCollectionService;//新冠抗原收藏
    @Autowired
    private XinguankangyuanLiuyanService xinguankangyuanLiuyanService;//新冠抗原留言
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
        PageUtils page = xinguankangyuanOrderService.queryPage(params);

        //字典表数据转换
        List<XinguankangyuanOrderView> list =(List<XinguankangyuanOrderView>)page.getList();
        for(XinguankangyuanOrderView c:list){
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
        XinguankangyuanOrderEntity xinguankangyuanOrder = xinguankangyuanOrderService.selectById(id);
        if(xinguankangyuanOrder !=null){
            //entity转view
            XinguankangyuanOrderView view = new XinguankangyuanOrderView();
            BeanUtils.copyProperties( xinguankangyuanOrder , view );//把实体数据重构到view中
            //级联表 收货地址
            //级联表
            AddressEntity address = addressService.selectById(xinguankangyuanOrder.getAddressId());
            if(address != null){
            BeanUtils.copyProperties( address , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setAddressId(address.getId());
            }
            //级联表 新冠抗原
            //级联表
            XinguankangyuanEntity xinguankangyuan = xinguankangyuanService.selectById(xinguankangyuanOrder.getXinguankangyuanId());
            if(xinguankangyuan != null){
            BeanUtils.copyProperties( xinguankangyuan , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setXinguankangyuanId(xinguankangyuan.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(xinguankangyuanOrder.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
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
    public R save(@RequestBody XinguankangyuanOrderEntity xinguankangyuanOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xinguankangyuanOrder:{}",this.getClass().getName(),xinguankangyuanOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            xinguankangyuanOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        xinguankangyuanOrder.setCreateTime(new Date());
        xinguankangyuanOrder.setInsertTime(new Date());
        xinguankangyuanOrderService.insert(xinguankangyuanOrder);

        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XinguankangyuanOrderEntity xinguankangyuanOrder, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,xinguankangyuanOrder:{}",this.getClass().getName(),xinguankangyuanOrder.toString());
        XinguankangyuanOrderEntity oldXinguankangyuanOrderEntity = xinguankangyuanOrderService.selectById(xinguankangyuanOrder.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            xinguankangyuanOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            xinguankangyuanOrderService.updateById(xinguankangyuanOrder);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<XinguankangyuanOrderEntity> oldXinguankangyuanOrderList =xinguankangyuanOrderService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        xinguankangyuanOrderService.deleteBatchIds(Arrays.asList(ids));

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
            List<XinguankangyuanOrderEntity> xinguankangyuanOrderList = new ArrayList<>();//上传的东西
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
                            XinguankangyuanOrderEntity xinguankangyuanOrderEntity = new XinguankangyuanOrderEntity();
//                            xinguankangyuanOrderEntity.setXinguankangyuanOrderUuidNumber(data.get(0));                    //订单编号 要改的
//                            xinguankangyuanOrderEntity.setAddressId(Integer.valueOf(data.get(0)));   //收货地址 要改的
//                            xinguankangyuanOrderEntity.setXinguankangyuanId(Integer.valueOf(data.get(0)));   //新冠抗原 要改的
//                            xinguankangyuanOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            xinguankangyuanOrderEntity.setBuyNumber(Integer.valueOf(data.get(0)));   //购买数量 要改的
//                            xinguankangyuanOrderEntity.setXinguankangyuanOrderTruePrice(data.get(0));                    //实付价格 要改的
//                            xinguankangyuanOrderEntity.setXinguankangyuanOrderTypes(Integer.valueOf(data.get(0)));   //订单类型 要改的
//                            xinguankangyuanOrderEntity.setXinguankangyuanOrderPaymentTypes(Integer.valueOf(data.get(0)));   //支付类型 要改的
//                            xinguankangyuanOrderEntity.setInsertTime(date);//时间
//                            xinguankangyuanOrderEntity.setCreateTime(date);//时间
                            xinguankangyuanOrderList.add(xinguankangyuanOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //订单编号
                                if(seachFields.containsKey("xinguankangyuanOrderUuidNumber")){
                                    List<String> xinguankangyuanOrderUuidNumber = seachFields.get("xinguankangyuanOrderUuidNumber");
                                    xinguankangyuanOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> xinguankangyuanOrderUuidNumber = new ArrayList<>();
                                    xinguankangyuanOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("xinguankangyuanOrderUuidNumber",xinguankangyuanOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //订单编号
                        List<XinguankangyuanOrderEntity> xinguankangyuanOrderEntities_xinguankangyuanOrderUuidNumber = xinguankangyuanOrderService.selectList(new EntityWrapper<XinguankangyuanOrderEntity>().in("xinguankangyuan_order_uuid_number", seachFields.get("xinguankangyuanOrderUuidNumber")));
                        if(xinguankangyuanOrderEntities_xinguankangyuanOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XinguankangyuanOrderEntity s:xinguankangyuanOrderEntities_xinguankangyuanOrderUuidNumber){
                                repeatFields.add(s.getXinguankangyuanOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [订单编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        xinguankangyuanOrderService.insertBatch(xinguankangyuanOrderList);
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
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = xinguankangyuanOrderService.queryPage(params);

        //字典表数据转换
        List<XinguankangyuanOrderView> list =(List<XinguankangyuanOrderView>)page.getList();
        for(XinguankangyuanOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XinguankangyuanOrderEntity xinguankangyuanOrder = xinguankangyuanOrderService.selectById(id);
            if(xinguankangyuanOrder !=null){


                //entity转view
                XinguankangyuanOrderView view = new XinguankangyuanOrderView();
                BeanUtils.copyProperties( xinguankangyuanOrder , view );//把实体数据重构到view中

                //级联表
                    AddressEntity address = addressService.selectById(xinguankangyuanOrder.getAddressId());
                if(address != null){
                    BeanUtils.copyProperties( address , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setAddressId(address.getId());
                }
                //级联表
                    XinguankangyuanEntity xinguankangyuan = xinguankangyuanService.selectById(xinguankangyuanOrder.getXinguankangyuanId());
                if(xinguankangyuan != null){
                    BeanUtils.copyProperties( xinguankangyuan , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setXinguankangyuanId(xinguankangyuan.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(xinguankangyuanOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
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
    public R add(@RequestBody XinguankangyuanOrderEntity xinguankangyuanOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,xinguankangyuanOrder:{}",this.getClass().getName(),xinguankangyuanOrder.toString());
            XinguankangyuanEntity xinguankangyuanEntity = xinguankangyuanService.selectById(xinguankangyuanOrder.getXinguankangyuanId());
            if(xinguankangyuanEntity == null){
                return R.error(511,"查不到该新冠抗原");
            }
            // Double xinguankangyuanNewMoney = xinguankangyuanEntity.getXinguankangyuanNewMoney();

            if(false){
            }
            else if(xinguankangyuanEntity.getXinguankangyuanNewMoney() == null){
                return R.error(511,"现价/积分不能为空");
            }
            else if((xinguankangyuanEntity.getXinguankangyuanKucunNumber() -xinguankangyuanOrder.getBuyNumber())<0){
                return R.error(511,"购买数量不能大于库存数量");
            }

            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");
            double balance = yonghuEntity.getNewMoney() - xinguankangyuanEntity.getXinguankangyuanNewMoney()*xinguankangyuanOrder.getBuyNumber();//余额
            if(balance<0)
                return R.error(511,"余额不够支付");
            xinguankangyuanOrder.setXinguankangyuanOrderTypes(101); //设置订单状态为已支付
            xinguankangyuanOrder.setXinguankangyuanOrderTruePrice(xinguankangyuanEntity.getXinguankangyuanNewMoney()*xinguankangyuanOrder.getBuyNumber()); //设置实付价格
            xinguankangyuanOrder.setYonghuId(userId); //设置订单支付人id
            xinguankangyuanOrder.setXinguankangyuanOrderUuidNumber(String.valueOf(new Date().getTime()));
            xinguankangyuanOrder.setXinguankangyuanOrderPaymentTypes(1);
            xinguankangyuanOrder.setInsertTime(new Date());
            xinguankangyuanOrder.setCreateTime(new Date());
                xinguankangyuanEntity.setXinguankangyuanKucunNumber( xinguankangyuanEntity.getXinguankangyuanKucunNumber() -xinguankangyuanOrder.getBuyNumber());
                xinguankangyuanService.updateById(xinguankangyuanEntity);
                xinguankangyuanOrderService.insert(xinguankangyuanOrder);//新增订单
            //更新第一注册表
            yonghuEntity.setNewMoney(balance);//设置金额
            yonghuService.updateById(yonghuEntity);


            return R.ok();
    }
    /**
     * 添加订单
     */
    @RequestMapping("/order")
    public R add(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("order方法:,,Controller:{},,params:{}",this.getClass().getName(),params.toString());
        String xinguankangyuanOrderUuidNumber = String.valueOf(new Date().getTime());

        //获取当前登录用户的id
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        Integer addressId = Integer.valueOf(String.valueOf(params.get("addressId")));

            Integer xinguankangyuanOrderPaymentTypes = Integer.valueOf(String.valueOf(params.get("xinguankangyuanOrderPaymentTypes")));//支付类型

        String data = String.valueOf(params.get("xinguankangyuans"));
        JSONArray jsonArray = JSON.parseArray(data);
        List<Map> xinguankangyuans = JSON.parseObject(jsonArray.toString(), List.class);

        //获取当前登录用户的个人信息
        YonghuEntity yonghuEntity = yonghuService.selectById(userId);

        //当前订单表
        List<XinguankangyuanOrderEntity> xinguankangyuanOrderList = new ArrayList<>();
        //商品表
        List<XinguankangyuanEntity> xinguankangyuanList = new ArrayList<>();

        BigDecimal zhekou = new BigDecimal(1.0);

        //循环取出需要的数据
        for (Map<String, Object> map : xinguankangyuans) {
           //取值
            Integer xinguankangyuanId = Integer.valueOf(String.valueOf(map.get("xinguankangyuanId")));//商品id
            Integer buyNumber = Integer.valueOf(String.valueOf(map.get("buyNumber")));//购买数量
            XinguankangyuanEntity xinguankangyuanEntity = xinguankangyuanService.selectById(xinguankangyuanId);//购买的商品
            String id = String.valueOf(map.get("id"));

            //判断商品的库存是否足够
            if(xinguankangyuanEntity.getXinguankangyuanKucunNumber() < buyNumber){
                //商品库存不足直接返回
                return R.error(xinguankangyuanEntity.getXinguankangyuanName()+"的库存不足");
            }else{
                //商品库存充足就减库存
                xinguankangyuanEntity.setXinguankangyuanKucunNumber(xinguankangyuanEntity.getXinguankangyuanKucunNumber() - buyNumber);
            }

            //订单信息表增加数据
            XinguankangyuanOrderEntity xinguankangyuanOrderEntity = new XinguankangyuanOrderEntity<>();

            //赋值订单信息
            xinguankangyuanOrderEntity.setXinguankangyuanOrderUuidNumber(xinguankangyuanOrderUuidNumber);//订单编号
            xinguankangyuanOrderEntity.setAddressId(addressId);//收货地址
            xinguankangyuanOrderEntity.setXinguankangyuanId(xinguankangyuanId);//新冠抗原
                        xinguankangyuanOrderEntity.setYonghuId(userId);//用户
            xinguankangyuanOrderEntity.setBuyNumber(buyNumber);//购买数量 ？？？？？？
            xinguankangyuanOrderEntity.setXinguankangyuanOrderTypes(101);//订单类型
            xinguankangyuanOrderEntity.setXinguankangyuanOrderPaymentTypes(xinguankangyuanOrderPaymentTypes);//支付类型
            xinguankangyuanOrderEntity.setInsertTime(new Date());//订单创建时间
            xinguankangyuanOrderEntity.setCreateTime(new Date());//创建时间

            //判断是什么支付方式 1代表余额 2代表积分
            if(xinguankangyuanOrderPaymentTypes == 1){//余额支付
                //计算金额
                Double money = new BigDecimal(xinguankangyuanEntity.getXinguankangyuanNewMoney()).multiply(new BigDecimal(buyNumber)).multiply(zhekou).doubleValue();

                if(yonghuEntity.getNewMoney() - money <0 ){
                    return R.error("余额不足,请充值！！！");
                }else{
                    //计算所获得积分
                    Double buyJifen =0.0;
                yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() - money); //设置金额


                    xinguankangyuanOrderEntity.setXinguankangyuanOrderTruePrice(money);

                }
            }
            xinguankangyuanOrderList.add(xinguankangyuanOrderEntity);
            xinguankangyuanList.add(xinguankangyuanEntity);

        }
        xinguankangyuanOrderService.insertBatch(xinguankangyuanOrderList);
        xinguankangyuanService.updateBatchById(xinguankangyuanList);
        yonghuService.updateById(yonghuEntity);

        return R.ok();
    }


    /**
    * 退款
    */
    @RequestMapping("/refund")
    public R refund(Integer id, HttpServletRequest request){
        logger.debug("refund方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));

            XinguankangyuanOrderEntity xinguankangyuanOrder = xinguankangyuanOrderService.selectById(id);//当前表service
            Integer buyNumber = xinguankangyuanOrder.getBuyNumber();
            Integer xinguankangyuanOrderPaymentTypes = xinguankangyuanOrder.getXinguankangyuanOrderPaymentTypes();
            Integer xinguankangyuanId = xinguankangyuanOrder.getXinguankangyuanId();
            if(xinguankangyuanId == null)
                return R.error(511,"查不到该新冠抗原");
            XinguankangyuanEntity xinguankangyuanEntity = xinguankangyuanService.selectById(xinguankangyuanId);
            if(xinguankangyuanEntity == null)
                return R.error(511,"查不到该新冠抗原");
            Double xinguankangyuanNewMoney = xinguankangyuanEntity.getXinguankangyuanNewMoney();
            if(xinguankangyuanNewMoney == null)
                return R.error(511,"新冠抗原价格不能为空");

            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
            return R.error(511,"用户金额不能为空");
            Double zhekou = 1.0;

            //判断是什么支付方式 1代表余额 2代表积分
            if(xinguankangyuanOrderPaymentTypes == 1){//余额支付
                //计算金额
                Double money = xinguankangyuanEntity.getXinguankangyuanNewMoney() * buyNumber  * zhekou;
                //计算所获得积分
                Double buyJifen = 0.0;
                yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() + money); //设置金额


            }

            xinguankangyuanEntity.setXinguankangyuanKucunNumber(xinguankangyuanEntity.getXinguankangyuanKucunNumber() + buyNumber);

            xinguankangyuanOrder.setXinguankangyuanOrderTypes(102);//设置订单状态为已退款
            xinguankangyuanOrderService.updateAllColumnById(xinguankangyuanOrder);//根据id更新
            yonghuService.updateById(yonghuEntity);//更新用户信息
            xinguankangyuanService.updateById(xinguankangyuanEntity);//更新订单中新冠抗原的信息

            return R.ok();
    }

    /**
     * 发货
     */
    @RequestMapping("/deliver")
    public R deliver(Integer id  , HttpServletRequest request){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        XinguankangyuanOrderEntity  xinguankangyuanOrderEntity = xinguankangyuanOrderService.selectById(id);
        xinguankangyuanOrderEntity.setXinguankangyuanOrderTypes(103);//设置订单状态为已发货
        xinguankangyuanOrderService.updateById( xinguankangyuanOrderEntity);

        return R.ok();
    }


    /**
     * 收货
     */
    @RequestMapping("/receiving")
    public R receiving(Integer id , HttpServletRequest request){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        XinguankangyuanOrderEntity  xinguankangyuanOrderEntity = xinguankangyuanOrderService.selectById(id);
        xinguankangyuanOrderEntity.setXinguankangyuanOrderTypes(104);//设置订单状态为收货
        xinguankangyuanOrderService.updateById( xinguankangyuanOrderEntity);
        return R.ok();
    }

}

