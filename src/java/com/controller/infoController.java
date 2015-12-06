package com.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class infoController {
   
        //测试
	@RequestMapping("/sayhi.action")
	public String print(ModelMap model){

            System.out.println("mode and view...");
            return "hello";
	}
        //查询最新的数据编号...
        @RequestMapping(value="/getNewestInfo.action")
        @ResponseBody()
	public String getNewestInfo(){
            
            System.out.println("search new info...");
            return "2015120199";
	}
         
         //作废 查询最新的数据编号...
        @RequestMapping(value="/getProductNum.action")
        @ResponseBody()
	public String getProductNum(){
            
            System.out.println("***search prodcut number***");
            return "12";
	}
        
        //作废
        @RequestMapping(value = "/getProductInfoByID.action", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
        @ResponseBody()
        public String getProductInfoByID(@RequestParam String id) throws UnsupportedEncodingException{
            
            System.out.println("id is: "+id);
        
            JSONObject json = new JSONObject(); 
            json.put("id", Integer.parseInt(id));
            json.put("name", "草根投资");
            json.put("title", "让投资实现梦想"+id);
            json.put("author", "老东"+id);
            json.put("descript", id+"例如，有保险的P2P平台——米缸金融，为投资者提供了年化4%的余额收益。即：无论是在平台充值后未投资，或者期满返还到账户中的余额，但凡是在米缸账户中的存量资金，都将以4%的年化收益按日获得回报。");
            json.put("headImage", "http://114.215.177.200:81/20151101/0.png");
            json.put("iconImage", "http://114.215.177.200:81/20151101/3.png");
            json.put("detailUrl", "http://www.sina.com.cn");
            json.put("comments", 12);
            json.put("flag0", 0);
            json.put("flag1", 0);
            return json.toString();
        } 
        
       
        //查询最新length个数据编号数组...
        @RequestMapping(value="/findNewestIDByLength.action",method = RequestMethod.GET, produces = "application/json; charset=utf-8")
        @ResponseBody()
	public String findNewestIDByLength(@RequestParam String num, String id){
            
            System.out.println("num is: "+num);
            System.out.println("id is: "+id);
            
            int Num=Integer.parseInt(num);
            int ID=Integer.parseInt(id);
            String result="";
            
            for(int i=1;i<Num+1;i++){
                
                int tmp=ID-i;
                result += String.valueOf(tmp);
                if(i<Num){
                    result += "*";
                }
            }
            System.out.println(result);
            return result;
            /*
            String[] array = new String[]{"2015110116","2015110115","2015110114"
            ,"2015110113","2015110112","2015110111","2015110110",
            "2015110109","2015110108","2015110107s"};
            return array.toString();
            */
        } 
        
        //需要get id参数
        @RequestMapping(value = "/getProductInfoByID2.action", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
        @ResponseBody()
        public String getProductInfoByID2(@RequestParam String id) throws UnsupportedEncodingException{
            
            System.out.println("id is: "+id);
            JSONObject json = new JSONObject(); 
            
            int num=Integer.parseInt(id);
            if(num%3 == 0){
                System.out.print("add 0");
                json.put("id", num);
                json.put("name", "草根投资");
                json.put("title", "让投资实现梦想"+id);
                json.put("author", "老东"+id);
                json.put("descript", id+"例如，有保险的P2P平台——米缸金融，为投资者提供了年化4%的余额收益。即：无论是在平台充值后未投资，或者期满返还到账户中的余额，但凡是在米缸账户中的存量资金，都将以4%的年化收益按日获得回报。");
                json.put("headImage", "http://114.215.177.200:81/20151101/0.png");
                json.put("iconImage", "http://114.215.177.200:81/20151101/3.png");
                json.put("downUrl", "itms-apps://itunes.apple.com/cn/app/cao-gen-tou-zi-tou-zi-cai/id912261455?mt=8");
            
                //detail is jsonArray
                JSONArray JsonArray = new JSONArray();
                JSONObject tmpJson = new JSONObject();
                tmpJson.put("type", 100);//type 100=title
                tmpJson.put("content", "这是标题0");
                JsonArray.add(tmpJson);
                tmpJson = new JSONObject();
                tmpJson.put("type", 101);//type 101=description
                tmpJson.put("content", "这是内容0这是内容0这是内容0这是内容0这是内容0这是内容0这是内容0这是内容0这是内容0这是内容0");
                JsonArray.add(tmpJson);
                tmpJson = new JSONObject();
                tmpJson.put("type", 102);//type 102=image
                tmpJson.put("content", "http://114.215.177.200:81/20151101/0.png");
                JsonArray.add(tmpJson);
            
                tmpJson = new JSONObject();
                tmpJson.put("type", 100);//type 100=title
                tmpJson.put("content", "这是标题1");
                JsonArray.add(tmpJson);
                tmpJson = new JSONObject();
                tmpJson.put("type", 101);//type 101=description
                tmpJson.put("content", "这是内容1这是内容1这是内容1这是内容1这是内容1这是内容1这是内容1这是内容1这是内容1这是内容1");
                JsonArray.add(tmpJson);
                tmpJson = new JSONObject();
                tmpJson.put("type", 102);//type 102=image
                tmpJson.put("content", "http://114.215.177.200:81/20151101/0.png");
                JsonArray.add(tmpJson);
                json.put("detailUrl", JsonArray); 
                json.put("comments", 12);
                json.put("flag0", 0);
                json.put("flag1", 0);
                
            }else if(num%3 == 1){
                
                System.out.print("add 1");
                json.put("id", num);
                json.put("name", "宜人贷");
                json.put("title", "个人抵押贷款");
                json.put("author", "西风烈");
                json.put("descript", id+"例如，有保险的P2P平台——米缸金融，为投资者提供了年化4%的余额收益。即：无论是在平台充值后未投资，或者期满返还到账户中的余额，但凡是在米缸账户中的存量资金，都将以4%的年化收益按日获得回报。");
                json.put("headImage", "http://114.215.177.200:81/20151126/0.png");
                json.put("iconImage", "http://114.215.177.200:81/20151126/1.png");
                json.put("downUrl", "itms-apps://itunes.apple.com/cn/app/yi-ren-dai-li-cai-wang-dai/id908623207?mt=8");
                
                //detail is jsonArray
                JSONArray JsonArray = new JSONArray();
                JSONObject tmpJson = new JSONObject();
                tmpJson.put("type", 100);//type 100=title
                tmpJson.put("content", "宜人贷的第一段介绍");
                JsonArray.add(tmpJson);
                tmpJson = new JSONObject();
                tmpJson.put("type", 101);//type 101=description
                tmpJson.put("content", "宜定盈V是宜人贷推出的固定期限类理财咨询服务。出借人通过宜定盈服务将资金出借给宜人贷平台上的精英标用户，采用智能投标、循环出借的方式，提高资金的流动率和利用率，从而增加实际收益。理财服务到期将自动退出，服务期内用户可申请续约。");
                JsonArray.add(tmpJson);
                tmpJson = new JSONObject();
                tmpJson.put("type", 102);//type 102=image
                tmpJson.put("content", "http://114.215.177.200:81/20151126/2.png");
                JsonArray.add(tmpJson);
            
                tmpJson = new JSONObject();
                tmpJson.put("type", 100);//type 100=title
                tmpJson.put("content", "宜人贷的第二段介绍");
                JsonArray.add(tmpJson);
                tmpJson = new JSONObject();
                tmpJson.put("type", 101);//type 101=description
                tmpJson.put("content", "宜定盈V是宜人贷推出的固定期限类理财咨询服务。出借人通过宜定盈服务将资金出借给宜人贷平台上的精英标用户，采用智能投标、循环出借的方式，提高资金的流动率和利用率，从而增加实际收益。理财服务到期将自动退出，服务期内用户可申请续约。");
                JsonArray.add(tmpJson);
                tmpJson = new JSONObject();
                tmpJson.put("type", 102);//type 102=image
                tmpJson.put("content", "http://114.215.177.200:81/20151126/2.png");
                JsonArray.add(tmpJson);
                json.put("detailUrl", JsonArray); 
                json.put("comments", 12);
                json.put("flag0", 0);
                json.put("flag1", 0);
                
            }else{
                
                System.out.print("add 2");
                json.put("id", num);
                json.put("name", "金斧子");
                json.put("title", "聪明你的投资");
                json.put("author", "西风烈");
                json.put("descript", id+"金斧子本系列产品将用于在校大学生日常生活用品、电子产品消费的借款。借款人均通过人人公司（NYSE：RENN）旗下的北京JWZHKJ有限公司严格审核，确保借款人信用及还款能力。");
                json.put("headImage", "http://114.215.177.200:81/20151128/0.png");
                json.put("iconImage", "http://114.215.177.200:81/20151128/1.png");
                json.put("downUrl", "itms-apps://itunes.apple.com/cn/app/jin-fu-zi-li-cai-mo-ni-chao/id994455679?mt=8");
                
                //detail is jsonArray
                JSONArray JsonArray = new JSONArray();
                JSONObject tmpJson = new JSONObject();
                tmpJson.put("type", 100);//type 100=title
                tmpJson.put("content", "金斧子的第一段介绍");
                JsonArray.add(tmpJson);
                tmpJson = new JSONObject();
                tmpJson.put("type", 101);//type 101=description
                tmpJson.put("content", "金斧子第一段内容银行票据类型为银行承兑汇票。融资方（即票据持有人）以银行承兑汇票作为质押物，由商业银行对融资方提交的银行承兑汇票进行验票和托收。投资者认购票据收益权。产品到期，承兑银行向投资人兑付本金和收益。");
                JsonArray.add(tmpJson);
                tmpJson = new JSONObject();
                tmpJson.put("type", 102);//type 102=image
                tmpJson.put("content", "http://114.215.177.200:81/20151128/2.png");
                JsonArray.add(tmpJson);
            
                tmpJson = new JSONObject();
                tmpJson.put("type", 100);//type 100=title
                tmpJson.put("content", "金斧子的第二段介绍");
                JsonArray.add(tmpJson);
                tmpJson = new JSONObject();
                tmpJson.put("type", 101);//type 101=description
                tmpJson.put("content", "金斧子第二段内容银行票据类型为银行承兑汇票。融资方（即票据持有人）以银行承兑汇票作为质押物，由商业银行对融资方提交的银行承兑汇票进行验票和托收。投资者认购票据收益权。产品到期，承兑银行向投资人兑付本金和收益。");
                JsonArray.add(tmpJson);
                tmpJson = new JSONObject();
                tmpJson.put("type", 102);//type 102=image
                tmpJson.put("content", "http://114.215.177.200:81/20151128/2.png");
                JsonArray.add(tmpJson);
                json.put("detailUrl", JsonArray); 
                json.put("comments", 12);
                json.put("flag0", 0);
                json.put("flag1", 0);
                
                tmpJson = new JSONObject();
                tmpJson.put("type", 100);//type 100=title
                tmpJson.put("content", "金斧子的第三段介绍");
                JsonArray.add(tmpJson);
                tmpJson = new JSONObject();
                tmpJson.put("type", 101);//type 101=description
                tmpJson.put("content", "金斧子第三段内容的银行票据类型为银行承兑汇票。融资方（即票据持有人）以银行承兑汇票作为质押物，由商业银行对融资方提交的银行承兑汇票进行验票和托收。投资者认购票据收益权。产品到期，承兑银行向投资人兑付本金和收益。");
                JsonArray.add(tmpJson);
                tmpJson = new JSONObject();
                tmpJson.put("type", 102);//type 102=image
                tmpJson.put("content", "http://114.215.177.200:81/20151128/2.png");
                JsonArray.add(tmpJson);
                json.put("detailUrl", JsonArray); 
                json.put("comments", 12);
                json.put("flag0", 0);
                json.put("flag1", 0);
            }
            return json.toString();
        } 
        
        /*
        @RequestMapping(value = "/testJsonArray.action", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
        @ResponseBody()
        public String testJsonArray(@RequestParam String id) throws UnsupportedEncodingException{
            
            System.out.println("test json array");
            System.out.println("id is: "+id);
        
            JSONObject json = new JSONObject(); 
            json.put("id", Integer.parseInt(id));
            json.put("name", "frank");

            JSONArray JsonArray = new JSONArray();
            JSONObject tmpJson = new JSONObject();
            tmpJson.put("num", 0);
            tmpJson.put("type", "title0");
            tmpJson.put("content", "这是内容0");
            JsonArray.add(tmpJson);
            tmpJson = new JSONObject();
            tmpJson.put("num", 1);
            tmpJson.put("type", "title1");
            tmpJson.put("content", "这是内容1");
            JsonArray.add(tmpJson);
            tmpJson = new JSONObject();
            tmpJson.put("num", 2);
            tmpJson.put("type", "title2");
            tmpJson.put("content", "这是内容2");
            JsonArray.add(tmpJson);
            
            json.put("detail", JsonArray);  
            return json.toString();      
	}
        */
}
