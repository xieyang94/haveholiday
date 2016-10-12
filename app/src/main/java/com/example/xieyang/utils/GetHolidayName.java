package com.example.xieyang.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Createdayay by Adayayministrator on 2016/7/24.
 */
public class GetHolidayName {

    public static String getHoliday(int year, int month, int day) {
        if (month == 1) {
            if (day == 1) {
                return "元旦";
            }
            if (day == 10) {
                return "110宣传日";
            }
            if (day == 14) {
                return "日记情人节";
            }
            if (day == 25) {
                String str="";
                if(getlastweekmafeng(year) == 25){
                    if(str.equals("")){
                        str=str+"国际麻风日";
                    }else{
                        str=str+","+"国际麻风日";
                    }
                }
                return str;
            }
            if (day == 26) {
                String str = "国际海关日";
                if (getlastweekmafeng(year) == 26) {
                    str = str + "," + "国际麻风日";
                }
                return str;
            }
            if (day == 27) {
                String str = "缅怀大屠杀遇难者的国际纪念日";
                if (getlastweekmafeng(year) == 27) {
                    str = str + "," + "国际麻风日";
                }
                return str;
            }
            if (day == 28) {
                String str="";
                if(getlastweekmafeng(year) == 28){
                    if(str.equals("")){
                        str=str+"国际麻风日";
                    }else{
                        str=str+","+"国际麻风日";
                    }
                }
                return str;
            }
            if (day == 29) {
                String str="";
                if(getlastweekmafeng(year) == 29){
                    if(str.equals("")){
                        str=str+"国际麻风日";
                    }else{
                        str=str+","+"国际麻风日";
                    }
                }
                return str;
            }
            if (day == 30 && getlastweekmafeng(year) == 30) {
                String str="";
                if(getlastweekmafeng(year) == 30){
                    if(str.equals("")){
                        str=str+"国际麻风日";
                    }else{
                        str=str+","+"国际麻风日";
                    }
                }
                return str;
            }
            if (day == 31 && getlastweekmafeng(year) == 31) {
                String str="";
                if(getlastweekmafeng(year) == 31){
                    if(str.equals("")){
                        str=str+"国际麻风日";
                    }else{
                        str=str+","+"国际麻风日";
                    }
                }
                return str;
            }
        } else if (month == 2) {
            if (day == 2) {
                return "世界湿地日";
            }
            if (day == 4) {
                return "世界癌症日";
            }
            if (day == 6) {
                return "切割女性生殖器零容忍国际日";
            }
            if (day == 12) {
                return "达尔文日";
            }
            if (day == 13) {
                return "世界无线电日";
            }
            if (day == 14) {
                return "情人节";
            }
            if (day == 20) {
                return "世界社会公正日";
            }
            if (day == 21) {
                return "国际母语日"+","+"反对殖民主义斗争日";
            }
            if (day == 28) {
                String str="";
                if(gettwomonthlastday(year)==28){
                    if(str.equals("")){
                        str=str+"世界居住条件调查日";
                    }else{
                        str=str+","+"世界居住条件调查日";
                    }
                }
                return str;
            }
            if (day == 29) {
                String str="";
                if(gettwomonthlastday(year)==29){
                    if(str.equals("")){
                        str=str+"世界居住条件调查日";
                    }else{
                        str=str+","+"世界居住条件调查日";
                    }
                }
                return str;
            }

        } else if (month == 3) {
            if (day == 1) {
                return "国际海豹日" + "," + "国际民防日";
            }
            if (day == 3) {
                return "全国爱耳日";
            }
            if (day == 5) {
                return "学习雷锋纪念日";
            }
            if (day == 6) {
                return "世界青光眼日";
            }
            if (day == 7) {
                return "女生节";
            }
            if (day == 8) {
                String str="国际劳动妇女节";
                if(shijieshenzangri(year)==8){
                    str=str+","+"世界肾脏日";
                }
                return str;
            }
            if (day == 9) {
                String str="保护母亲河日";
                if(shijieshenzangri(year)==9){
                    str=str+","+"世界肾脏日";
                }
                return str;
            }
            if(day==10){
                String str="";
                if(shijieshenzangri(year)==10){
                    if(str.equals("")){
                        str=str+"世界肾脏日";
                    }else{
                        str=str+","+"世界肾脏日";
                    }
                }
                return str;
            }
            if (day == 11) {
                String str="国际尊严尊敬日";
                if(shijieshenzangri(year)==11){
                    str=str+","+"世界肾脏日";
                }
                return str;
            }
            if (day == 12) {
                String str="中国植树节";
                if(shijieshenzangri(year)==12){
                    str=str+","+"世界肾脏日";
                }
                return str;
            }
            if(day==13){
                String str="";
                if(shijieshenzangri(year)==13){
                    if(str.equals("")){
                        str=str+"世界肾脏日";
                    }else{
                        str=str+","+"世界肾脏日";
                    }
                }
                return str;
            }
            if (day == 14) {
                String str="圆周率日" + "," + "国际警察日" + "," + "白色情人节";
                if(shijieshenzangri(year)==14){
                    str=str+","+"世界肾脏日";
                }
                return str;
            }
            if (day == 15) {
                return "国际消费者权益日";
            }
            if (day == 16) {
                return "手拉手情系贫困小伙伴全国统一行动日";
            }
            if (day == 17) {
                return "国际航海日";
            }
            if (day == 20) {
                return "阿露窝罗节" + "," + "国际法语日" + "," + "国际幸福日" + "," + "世界无肉日";
            }
            if (day == 21) {
                return "世界森林日" + "," + "世界儿歌日" + "," + "世界睡眠日" + "," + "世界消除种族歧视日" + "," + "世界诗歌日" + "," + "国际诺鲁孜节" + "," + "世界唐氏综合征日";
            }
            if (day == 22) {
                return "世界水日";
            }
            if (day == 23) {
                return "世界气象日";
            }
            if (day == 24) {
                return "世界防治结核病日" + "," + "了解严重侵犯人权行为真相权利维护受害者尊严国际日";
            }
            if (day == 25) {
                String str="声援被拘留或失踪工作人员国际日" + "," + "奴隶制和跨大西洋贩卖奴隶行为受害者国际纪念日";
                if(diqiuyixiaoshi(year)==25){
                    str=str+","+"地球一小时";
                }
                if(safeeducation(year)==25){
                    str=str+","+"全国中小学生安全教育日";
                }
                return str;
            }
            if(day==26){
                String str="";
                if(diqiuyixiaoshi(year)==26){
                    if(str.equals("")){
                        str=str+"地球一小时";
                    }else{
                        str=str+","+"地球一小时";
                    }
                }
                if(safeeducation(year)==26){
                    if(str.equals("")){
                        str=str+"全国中小学生安全教育日";
                    }else{
                        str=str+","+"全国中小学生安全教育日";
                    }
                }
                return str;
            }
            if (day == 27) {
                String str="世界戏剧日";
                if(diqiuyixiaoshi(year)==27){
                    str=str+","+"地球一小时";
                }
                if(safeeducation(year)==27){
                    str=str+","+"全国中小学生安全教育日";
                }
                return str;
            }
            if (day == 28) {
                String str="西藏百万农奴解放纪念日";
                if(diqiuyixiaoshi(year)==28){
                    str=str+","+"地球一小时";
                }
                if(safeeducation(year)==28){
                    str=str+","+"全国中小学生安全教育日";
                }
                return str;
            }
            if(day==29){
                String str="";
                if(diqiuyixiaoshi(year)==29){
                    if(str.equals("")){
                        str=str+"地球一小时";
                    }else{
                        str=str+","+"地球一小时";
                    }
                }
                if(safeeducation(year)==29){
                    if(str.equals("")){
                        str=str+"全国中小学生安全教育日";
                    }else{
                        str=str+","+"全国中小学生安全教育日";
                    }
                }
                return str;
            }
            if(day==30){
                String str="";
                if(diqiuyixiaoshi(year)==30){
                    if(str.equals("")){
                        str=str+"地球一小时";
                    }else{
                        str=str+","+"地球一小时";
                    }
                }
                if(safeeducation(year)==30){
                    if(str.equals("")){
                        str=str+"全国中小学生安全教育日";
                    }else{
                        str=str+","+"全国中小学生安全教育日";
                    }
                }
                return str;
            }
            if(day==31){
                String str="";
                if(diqiuyixiaoshi(year)==31){
                    if(str.equals("")){
                        str=str+"地球一小时";
                    }else{
                        str=str+","+"地球一小时";
                    }
                }
                if (safeeducation(year)==31){
                    if(str.equals("")){
                        str=str+"全国中小学生安全教育日";
                    }else{
                        str=str+","+"全国中小学生安全教育日";
                    }
                }
                return str;
            }
        } else if (month == 4) {
            if (day == 1) {
                return "国际愚人节";
            }
            if (day == 2) {
                return "国际儿童图书日" + "," + "世界提高自闭症意识日";
            }
            if (day == 4) {
                return "国际提高地雷意识和协助地雷行动日";
            }
            if (day == 5) {
                return "巴勒斯坦儿童日";
            }
            if (day == 7) {
                return "世界卫生日" + "," + "卢旺达境内灭绝种族罪行国际反思日"+","+"世界高血压日";
            }
            if (day == 8) {
                String str="国际罗姆人日";
                if(quanqiuqingnianfuwuri(year)==8){
                    str=str+","+"全球青年服务日";
                }
                return str;
            }
            if (day == 9) {
                String str="";
                if(quanqiuqingnianfuwuri(year)==9){
                    if(str.equals("")){
                        str=str+"全球青年服务日";
                    }else{
                        str=str+","+"全球青年服务日";
                    }
                }
                return str;
            }
            if (day == 10) {
                String str="非洲环境保护日";
                if(quanqiuqingnianfuwuri(year)==10){
                    str=str+","+"全球青年服务日";
                }
                return str;
            }
            if (day == 11) {
                String str="世界帕金森病日";
                if(quanqiuqingnianfuwuri(year)==11){
                    str=str+","+"全球青年服务日";
                }
                return str;
            }
            if (day == 12) {
                String str="载人空间飞行国际日";
                if(quanqiuqingnianfuwuri(year)==12){
                    str=str+","+"全球青年服务日";
                }
            }
            if (day == 13) {
                String str="";
                if(quanqiuqingnianfuwuri(year)==13){
                    if(str.equals("")){
                        str=str+"全球青年服务日";
                    }else{
                        str=str+","+"全球青年服务日";
                    }
                }
                return str;
            }
            if (day == 14) {
                String str="黑色情人节";
                if(quanqiuqingnianfuwuri(year)==14){
                    str=str+","+"全球青年服务日";
                }
                return str;
            }
            if (day == 15) {
                return "非洲自由日"+","+"世界社会工作日";
            }
            if (day == 17) {
                return "世界血友病日";
            }
            if (day == 18) {
                return "国际古迹遗址日";
            }
            if (day == 20) {
                String str="";
                if(guojimishuri(year)==20){
                    if(str.equals("")){
                        str=str+"国际秘书日";
                    }else{
                        str=str+","+"国际秘书日";
                    }
                }
                return str;
            }
            if (day == 21) {
                String str="全国企业家活动日";
                if(guojimishuri(year)==21){
                    str=str+","+"国际秘书日";
                }
                return str;
            }
            if (day == 22) {
                String str="世界地球日" + "," + "世界法律日";
                if(shijieritongri(year)==22){
                    str=str+","+"世界儿童日";
                }
                if(guojimishuri(year)==22){
                    str=str+","+"国际秘书日";
                }
                return str;
            }
            if (day == 23) {
                String str="世界图书和版权日";
                if(shijieritongri(year)==23){
                    str=str+","+"世界儿童日";
                }
                if(guojimishuri(year)==23){
                    str=str+","+"国际秘书日";
                }
                return str;
            }
            if (day == 24) {
                String str="世界实验动物日";
                if(shijieritongri(year)==24){
                    str=str+","+"世界儿童日";
                }
                if(guojimishuri(year)==23){
                    str=str+","+"国际秘书日";
                }
                return str;
            }
            if (day == 25) {
                String str="全国预防接种宣传日" + "," + "世界防治疟疾日";
                if(shijieritongri(year)==25){
                    str=str+","+"世界儿童日";
                }
                if(guojimishuri(year)==24){
                    str=str+","+"国际秘书日";
                }
                return str;
            }
            if (day == 26) {
                String str="世界知识产权日";
                if(shijieritongri(year)==26){
                    str=str+","+"世界儿童日";
                }
                if (guojimishuri(year)==26){
                    str=str+","+"国际秘书日";
                }
                return str;
            }
            if(day==27){
                String str="";
                if(shijieritongri(year)==27){
                    if(str.equals("")){
                        str=str+"世界儿童日";
                    }else{
                        str=str+","+"世界儿童日";
                    }
                }
                return str;
            }
            if(day==28){
                String str="世界安全生产与健康日";
                if(shijieritongri(year)==28){
                    str=str+","+"世界儿童日";
                }
                return str;
            }
            if (day == 29) {
                return "世界舞蹈日" + "," + "化学战受害者纪念日";
            }
            if (day == 30) {
                return "国际爵士乐日"+","+"全国交通安全反思日";
            }

        } else if (month == 5) {
            if (day == 1) {
                String str= "国际劳动节";
                if(shijiexiaochuanri(year)==1){
                    str=str+","+"世界哮喘日";
                }
                return str;
            }
            if (day == 2) {
                String str="";
                if(shijiexiaochuanri(year)==2){
                    if(str.equals("")){
                        str=str+"世界哮喘日";
                    }
                    else{
                        str=str+","+"世界哮喘日";
                    }
                }
                return str;
            }
            if (day == 3) {
                String str= "世界新闻自由日";
                if(shijiexiaochuanri(year)==3){
                    str=str+","+"世界哮喘日";
                }
                return str;
            }
            if (day == 4) {
                String str= "中国青年节";
                if(shijiexiaochuanri(year)==4){
                    str=str+","+"世界哮喘日";
                }
                return str;
            }
            if (day == 5) {
                String str="";
                if(shijiexiaochuanri(year)==5){
                    if(str.equals("")){
                        str=str+"世界哮喘日";
                    }
                    else{
                        str=str+","+"世界哮喘日";
                    }
                }
                return str;
            }
            if (day == 6) {
                String str="";
                if(shijiexiaochuanri(year)==6){
                    if(str.equals("")){
                        str=str+"世界哮喘日";
                    }
                    else{
                        str=str+","+"世界哮喘日";
                    }
                }
                return str;
            }
            if (day == 7) {
                String str="";
                if(shijiexiaochuanri(year)==7){
                    if(str.equals("")){
                        str=str+"世界哮喘日";
                    }
                    else{
                        str=str+","+"世界哮喘日";
                    }
                }
                return str;
            }
            if (day == 8) {
                String str="世界微笑日" + "," + "世界红十字日";
                if(houliaori(year)==8){
                    str=str+","+"世界候鸟日";
                }
                if(motherday(year)==8){
                    str=str+","+"母亲节";
                }
                return str;
            }
            if (day == 9) {
                String str="欧洲日"+","+"战胜德国法西斯纪念日";
                if(houliaori(year)==9){
                    str=str+","+"世界候鸟日";
                }
                if(motherday(year)==9){
                    str=str+","+"母亲节";
                }
                return str;
            }
            if(day==10){
                String str="";
                if(houliaori(year)==10){
                    if(str.equals("")){
                        str=str+"世界候鸟日";
                    }
                    else{
                        str=str+","+"世界候鸟日";
                    }
                }
                if(motherday(year)==10){
                    if(str.equals("")){
                        str=str+"母亲节";
                    }
                    else{
                        str=str+","+"母亲节";
                    }
                }
                return str;
            }
            if(day==11){
                String str="";
                if(houliaori(year)==11){
                    if(str.equals("")){
                        str=str+"世界候鸟日";
                    }
                    else{
                        str=str+","+"世界候鸟日";
                    }
                }
                if(motherday(year)==11){
                    if(str.equals("")){
                        str=str+"母亲节";
                    }
                    else{
                        str=str+","+"母亲节";
                    }
                }
                return str;
            }
            if (day == 12) {
                String str="国际护士节" + "," + "全国防灾减灾日";
                if(houliaori(year)==12){
                        str=str+","+"世界候鸟日";
                }
                if(motherday(year)==12){
                    str=str+","+"母亲节";
                }
                return str;
            }
            if(day==13){
                String str="";
                if(houliaori(year)==13){
                    if(str.equals("")){
                        str=str+"世界候鸟日";
                    }
                    else{
                        str=str+","+"世界候鸟日";
                    }
                }
                if(motherday(year)==13){
                    if(str.equals("")){
                        str=str+"母亲节";
                    }
                    else{
                        str=str+","+"母亲节";
                    }
                }
                return str;
            }
            if(day==14){
                String str="玫瑰情人节";
                if(houliaori(year)==14){
                    str=str+","+"世界候鸟日";
                }
                if(motherday(year)==14){
                    str=str+","+"母亲节";
                }
                return str;
            }
            if (day == 15) {
                String str="国际家庭日" + "," + "全国碘缺乏病宣传日";
                if(quanguozhucanri(year)==15){
                        str=str+","+"全国助残日";
                }
                return str;
            }
            if(day==16){
                String str="";
                if(quanguozhucanri(year)==16){
                    if(str.equals("")){
                        str=str+"全国助残日";
                    }else{
                        str=str+","+"全国助残日";
                    }
                }
                return str;
            }
            if (day == 17) {
                String str="世界电信日" + "," + "国际不再恐同日";
                if(quanguozhucanri(year)==17){
                    str=str+","+"全国助残日";
                }
                return str;
            }
            if (day == 18) {
                String str="国际植物日" + "," + "国际博物馆日";
                if(quanguozhucanri(year)==18){
                    str=str+","+"全国助残日";
                }
                return str;
            }
            if (day == 19) {
                String str="中国旅游日";
                if(quanguozhucanri(year)==19){
                    str=str+","+"全国助残日";
                }
                return str;
            }
            if (day == 20) {
                String str="世界计量日" + "," + "全国母乳喂养宣传日" + "," + "中国学生营养日";
                if(quanguozhucanri(year)==20){
                    str=str+","+"全国助残日";
                }
                return str;
            }
            if (day == 21) {
                String str="世界文化多样性促进对话和发展日";
                if(quanguozhucanri(year)==21){
                    str=str+","+"全国助残日";
                }
                return str;
            }
            if (day == 22) {
                return "国际生物多样性日";
            }
            if (day == 25) {
                return "非洲解放日";
            }
            if (day == 26) {
                return "世界向人体条件挑战日";
            }
            if (day == 29) {
                return "联合国维持和平人员国际日";
            }
            if (day == 31) {
                return "世界无烟日";
            }

        } else if (month == 6) {
            if (day == 1) {
                return "国际儿童节"+ "," + "国际牛奶日";
            }
            if (day == 4) {
                return "受侵略戕害的无辜儿童国际日";
            }
            if (day == 5) {
                return "世界环境日";
            }
            if (day == 6) {
                return "俄语日" + "," + "全国爱眼日";
            }
            if (day == 8) {
                String str="世界海洋日";
                if(zhongguowenhuayichan(year)==8){
                    str=str+","+"中国文化遗产日";
                }
                return str;
            }
            if(day==9){
                String str="";
                if(zhongguowenhuayichan(year)==9){
                    if(str.equals("")){
                        str=str+"中国文化遗产日";
                    }else{
                        str=str+","+"中国文化遗产日";
                    }
                }
                return str;
            }
            if(day==10){
                String str="";
                if(zhongguowenhuayichan(year)==10){
                    if(str.equals("")){
                        str=str+"中国文化遗产日";
                    }else{
                        str=str+","+"中国文化遗产日";
                    }
                }
                return str;
            }
            if(day==11){
                String str="";
                if(zhongguowenhuayichan(year)==11){
                    if(str.equals("")){
                        str=str+"中国文化遗产日";
                    }else{
                        str=str+","+"中国文化遗产日";
                    }
                }
                return str;
            }
            if (day == 12) {
                String str="世界无童工日";
                if(zhongguowenhuayichan(year)==12){
                    str=str+","+"中国文化遗产日";
                }
                return str;
            }
            if(day==13){
                String str="";
                if(zhongguowenhuayichan(year)==13){
                    if(str.equals("")){
                        str=str+"中国文化遗产日";
                    }else{
                        str=str+","+"中国文化遗产日";
                    }
                }
                return str;
            }
            if (day == 14) {
                String str="亲亲情人节"+","+"世界献血者日";
                if(zhongguowenhuayichan(year)==14){
                    str=str+","+"中国文化遗产日";
                }
                return str;
            }
            if (day == 15) {
                String str="认识虐待老年人问题世界日";
                if(fatherday(year)==15){
                    str=str+","+"父亲节";
                }
                return  str;
            }
            if(day==16){
                String str="";
                if(fatherday(year)==16){
                    if(str.equals("")){
                        str=str+"父亲节";
                    }else{
                        str=str+","+"父亲节";
                    }
                }
                return  str;
            }
            if (day == 17) {
                String str="世界防治荒漠化和干旱日";
                if(fatherday(year)==17){
                    str=str+","+"父亲节";
                }
                return  str;
            }
            if(day==18){
                String str="";
                if(fatherday(year)==18){
                    if(str.equals("")){
                        str=str+"父亲节";
                    }else{
                        str=str+","+"父亲节";
                    }
                }
                return  str;
            }
            if(day==19){
                String str="";
                if(fatherday(year)==19){
                    if(str.equals("")){
                        str=str+"父亲节";
                    }else{
                        str=str+","+"父亲节";
                    }
                }
                return  str;
            }
            if (day == 20) {
                String str="世界难民日";
                if(fatherday(year)==20){
                        str=str+","+"父亲节";
                }
                return  str;
            }
            if(day==21){
                String str="";
                if(fatherday(year)==21){
                    if(str.equals("")){
                        str=str+"父亲节";
                    }else{
                        str=str+","+"父亲节";
                    }
                }
                return  str;
            }
            if (day == 23) {
                return "国际奥林匹克日" + "," + "国际丧偶妇女日" + "," + "联合国公务员日";
            }
            if (day == 25) {
                return "海员日" + "," + "全国土地日";
            }
            if (day == 26) {
                return "国际禁毒日" + "," + "联合国宪章日" + "," + "支持酷刑受害者国际日";
            }
        } else if (month == 7) {
            if (day == 1) {
                String str="中共建党节" + "," + "香港回归纪念日";
                if(guojihezuosheri(year)==1){
                    str=str+","+"国际合作社日";
                }
                return str;
            }
            if (day == 2) {
                String str="世界UFO日" + "," + "国际体育记者日";
                if(guojihezuosheri(year)==2){
                    str=str+","+"国际合作社日";
                }
                return str;
            }
            if(day==3){
                String str="";
                if(guojihezuosheri(year)==3){
                    if(str.equals("")){
                        str=str+"国际合作社日";
                    }else{
                        str=str+","+"国际合作社日";
                    }
                }
                return str;
            }
            if(day==4){
                String str="";
                if(guojihezuosheri(year)==4){
                    if(str.equals("")){
                        str=str+"国际合作社日";
                    }else{
                        str=str+","+"国际合作社日";
                    }
                }
                return str;
            }
            if(day==5){
                String str="";
                if(guojihezuosheri(year)==5){
                    if(str.equals("")){
                        str=str+"国际合作社日";
                    }else{
                        str=str+","+"国际合作社日";
                    }
                }
                return str;
            }
            if (day == 6) {
                String str="国际接吻日";
                if(guojihezuosheri(year)==6){
                    str=str+","+"国际合作社日";
                }
                return str;
            }
            if (day == 7) {
                String str="中国人民抗日战争纪念日";
                if(guojihezuosheri(year)==7){
                    str=str+","+"国际合作社日";
                }
                return str;
            }
            if (day == 8) {
                return "世界过敏性疾病日";
            }
            if (day == 11) {
                return "世界人口日";
            }
            if (day == 14) {
                return "银色情人节";
            }
            if (day == 18) {
                return "纳尔逊·曼德拉国际日";
            }
            if (day == 20) {
                return "人类月球日";
            }
            if (day == 26) {
                return "世界语言创立日";
            }
            if (day == 28) {
                return "世界肝炎日";
            }
            if (day == 29) {
                return "国际老虎日";
            }
            if (day == 30) {
                return "国际友谊日";
            }
        } else if (month == 8) {
            if (day == 1) {
                return "中国人民解放军建军日";
            }
            if (day == 5) {
                return "国际啤酒日";
            }
            if (day == 6) {
                return "苗族吃新节";
            }
            if (day == 8) {
                return "全民健身日";
            }
            if (day == 9) {
                return "世界土著人民国际日";
            }
            if (day == 12) {
                return "国际青年日";
            }
            if (day == 14) {
                return "绿色情人节";
            }
            if (day == 19) {
                return "世界人道主义日";
            }
            if (day == 23) {
                return "贩卖黑奴及其废除的国际纪念日";
            }
            if (day == 26) {
                return "纳米比亚日"+","+"全国律师咨询日";
            }
            if (day == 29) {
                return "禁止核试验国际日";
            }
            if (day == 30) {
                return "强迫失踪受害者国际日";
            }

        } else if (month == 9) {
            if (day == 3) {
                return "抗日战争胜利纪念日";
            }
            if (day == 5) {
                return "国际慈善日";
            }


            if (day == 8) {
                String str="国际扫盲日";
                if(shijiejijiuri(year)==8){
                    str = str + "," + "世界急救日";
                }
                return str;
            }
            if(day==9){
                String str="";
                if(shijiejijiuri(year)==9){
                    if(str.equals("")){
                        str=str+"世界急救日";
                    }else {
                        str = str + "," + "世界急救日";
                    }
                }
                return str;
            }
            if (day == 10) {
                String str="中国教师节" + "," + "世界预防自杀日";
                if(shijiejijiuri(year)==10){
                    str = str + "," + "世界急救日";
                }
                return str;
            }
            if(day==11){
                String str="";
                if(shijiejijiuri(year)==11){
                    if(str.equals("")){
                        str=str+"世界急救日";
                    }else {
                        str = str + "," + "世界急救日";
                    }
                }
                return str;
            }
            if (day == 12) {
                String str="联合国南南合作日";
                if(shijiejijiuri(year)==12){
                    str = str + "," + "世界急救日";
                }
                return str;
            }
            if(day==13){
                String str="";
                if(shijiejijiuri(year)==13){
                    if(str.equals("")){
                        str=str+"世界急救日";
                    }else {
                        str = str + "," + "世界急救日";
                    }
                }
                return str;
            }
            if(day==14){
                String str="相片情人节";
                if(shijiejijiuri(year)==14){
                    str = str + "," + "世界急救日";
                }
                return str;
            }
            if (day == 15) {
                String str="国际民主日";
                if(quanminguofang(year)==15){
                        str=str+","+"全民国防教育日";
                }
                if(quanminkepu(year)==15){
                        str=str+","+"全国科普日";
                }
                if(shijieqingjiediqiuri(year)==15){
                        str=str+","+"世界清洁地球日";
                }
                return str;
            }
            if (day == 16) {
                String str="中国脑健康日" + "," + "国际臭氧层保护日";
                if(quanminguofang(year)==16){
                    str=str+","+"全民国防教育日";
                }
                if(quanminkepu(year)==16){
                    str=str+","+"全国科普日";
                }
                if(shijieqingjiediqiuri(year)==16){
                    str=str+","+"世界清洁地球日";
                }
                return str;
            }
            if(day==17){
                String str="";
                if(quanminguofang(year)==17){
                    if(str.equals("")){
                        str=str+"全民国防教育日";
                    }else{
                        str=str+","+"全民国防教育日";
                    }
                }
                if(quanminguofang(year)==17){
                    if(str.equals("")){
                        str=str+"全国科普日";
                    }else{
                        str=str+","+"全国科普日";
                    }
                }
                if(shijieqingjiediqiuri(year)==17){
                    if(str.equals("")){
                        str=str+"世界清洁地球日";
                    }else{
                        str=str+","+"世界清洁地球日";
                    }
                }
                return str;
            }
            if (day == 18) {
                String str="中国国耻日" + "," + "世界水检测日";
                if(quanminguofang(year)==18){
                    str=str+","+"全民国防教育日";
                }
                if(quanminkepu(year)==18){
                    str=str+","+"全国科普日";
                }
                if(shijieqingjiediqiuri(year)==18){
                    str=str+","+"世界清洁地球日";
                }
                return str;
            }
            if(day==19){
                String str="";
                if(quanminguofang(year)==19){
                    if(str.equals("")){
                        str=str+"全民国防教育日";
                    }else{
                        str=str+","+"全民国防教育日";
                    }
                }
                if(quanminguofang(year)==19){
                    if(str.equals("")){
                        str=str+"全国科普日";
                    }else{
                        str=str+","+"全国科普日";
                    }
                }
                if(shijieqingjiediqiuri(year)==19){
                    if(str.equals("")){
                        str=str+"世界清洁地球日";
                    }else{
                        str=str+","+"世界清洁地球日";
                    }
                }
                return str;
            }
            if (day == 20) {
                String str="全国爱牙日" + "," + "全国公民道德宣传日";
                if(quanminguofang(year)==20){
                    str=str+","+"全民国防教育日";
                }
                if(quanminkepu(year)==20){
                    str=str+","+"全国科普日";
                }
                if(shijieqingjiediqiuri(year)==20){
                    str=str+","+"世界清洁地球日";
                }
                return str;
            }
            if (day == 21) {
                String str="世界停火日" + "," + "国际和平日" + "," + "世界老年痴呆日";
                if (quanminguofang(year)==21){
                    str=str+","+"全民国防教育日";
                }
                if(quanminkepu(year)==21){
                    str=str+","+"全国科普日";
                }
                if(shijieqingjiediqiuri(year)==21){
                    str=str+","+"世界清洁地球日";
                }
                return str;
            }
            if (day == 22) {
                return "无车日";
            }
            if (day == 24) {
                String str="";
                if(getlastweeklongren(year)==24){
                    if(str.equals("")){
                        str=str+"国际聋人节";
                    }else{
                        str=str+","+"国际聋人节";
                    }
                }
                if(shijiehaishiri(year)==24){
                    if(str.equals("")){
                        str=str+"世界海事日";
                    }else{
                        str=str+","+"世界海事日";
                    }
                }
                return str;
            }
            if (day == 25) {
                String str="";
                if(getlastweeklongren(year)==25){
                    if(str.equals("")){
                        str=str+"国际聋人节";
                    }else{
                        str=str+","+"国际聋人节";
                    }
                }
                if(shijiehaishiri(year)==25){
                    if(str.equals("")){
                        str=str+"世界海事日";
                    }else{
                        str=str+","+"世界海事日";
                    }
                }
                return str;
            }
            if (day == 26) {
                String str="";
                if(getlastweeklongren(year)==26){
                    if(str.equals("")){
                        str=str+"国际聋人节";
                    }else{
                        str=str+","+"国际聋人节";
                    }
                }
                if(shijiehaishiri(year)==26){
                    if(str.equals("")){
                        str=str+"世界海事日";
                    }else{
                        str=str+","+"世界海事日";
                    }
                }
                return str;
            }
            if (day == 27) {
                String str="世界旅游日";
                if(getlastweeklongren(year)==27){
                    str=str+","+"国际聋人节";
                }
                if(shijiehaishiri(year)==27){
                    str=str+","+"世界海事日";
                }
                return str;
            }
            if (day == 28) {
                String str="国际知情日" + "," + "世界狂犬病日";
                if(getlastweeklongren(year)==28){
                    str=str+","+"国际聋人节";
                }
                if(shijiehaishiri(year)==28){
                    str=str+","+"世界海事日";
                }
                return str;
            }
            if (day == 29) {
                String str="世界心脏日";
                if(getlastweeklongren(year)==29){
                    str=str+","+"国际聋人节";
                }
                if(shijiehaishiri(year)==29){
                    str=str+","+"世界海事日";
                }
                return str;
            }
            if (day == 30) {
                String str="国际翻译日";
                if(getlastweeklongren(year)==30){
                    str=str+","+"国际聋人节";
                }
                if(shijiehaishiri(year)==30){
                    str=str+","+"世界海事日";
                }
                return str;
            }
        } else if (month == 10) {
            if (day == 1) {
                String str="国庆节" + "," + "国际老年人日"+ "," + "国际音乐日" + "," + "世界素食日";
                if(shijielinzhongguanhuai(year)==1){
                    str=str+","+"世界临终关怀及舒缓治疗日";
                }
                if(guojizhufangri(year)==1){
                    str=str+","+"国际住房日";
                }
                if(shijiejianzhuri(year)==1){
                    str=str+","+"世界建筑日";
                }
                return str;
            }
            if (day == 2) {
                String str="国际非暴力日"+","+"国际和平与民主自由斗争日";
                if(shijielinzhongguanhuai(year)==2){
                    str=str+","+"世界临终关怀及舒缓治疗日";
                }
                if(guojizhufangri(year)==2){
                    str=str+","+"国际住房日";
                }
                if(shijiejianzhuri(year)==2){
                    str=str+","+"世界建筑日";
                }
                return str;
            }
            if(day==3){
                String str="";
                if(shijielinzhongguanhuai(year)==3){
                    if(str.equals("")){
                        str=str+"世界临终关怀及舒缓治疗日";
                    }else{
                        str=str+","+"世界临终关怀及舒缓治疗日";
                    }
                }
                if(guojizhufangri(year)==3){
                    if(str.equals("")){
                        str=str+"国际住房日";
                    }else{
                        str=str+","+"国际住房日";
                    }
                }
                if(shijiejianzhuri(year)==3){
                    if(str.equals("")){
                        str=str+"世界建筑日";
                    }else{
                        str=str+","+"世界建筑日";
                    }
                }
                return str;
            }
            if (day == 4) {
                String str="世界动物日";
                if(shijielinzhongguanhuai(year)==4){
                    str=str+","+"世界临终关怀及舒缓治疗日";
                }
                if(guojizhufangri(year)==4){
                    str=str+","+"国际住房日";
                }
                if(shijiejianzhuri(year)==4){
                    str=str+","+"世界建筑日";
                }
                return str;
            }
            if (day == 5) {
                String str="世界教师日";
                if(shijielinzhongguanhuai(year)==5){
                    str=str+","+"世界临终关怀及舒缓治疗日";
                }
                if(guojizhufangri(year)== 5) {
                    str=str+","+"国际住房日";
                }
                if(shijiejianzhuri(year)==5){
                    str=str+","+"世界建筑日";
                }
                return str;
            }
            if(day==6){
                String str="";
                if(shijielinzhongguanhuai(year)==6){
                    if(str.equals("")){
                        str=str+"世界临终关怀及舒缓治疗日";
                    }else{
                        str=str+","+"世界临终关怀及舒缓治疗日";
                    }
                }
                if(guojizhufangri(year)==6){
                    if(str.equals("")){
                        str=str+"国际住房日";
                    }else{
                        str=str+","+"国际住房日";
                    }
                }
                if(shijiejianzhuri(year)==6){
                    if(str.equals("")){
                        str=str+"世界建筑日";
                    }else{
                        str=str+","+"世界建筑日";
                    }
                }
                return str;
            }
            if(day==7){
                String str="";
                if(shijielinzhongguanhuai(year)==7){
                    if(str.equals("")){
                        str=str+"世界临终关怀及舒缓治疗日";
                    }else{
                        str=str+","+"世界临终关怀及舒缓治疗日";
                    }
                }
                if(guojizhufangri(year)==7){
                    if(str.equals("")){
                        str=str+"国际住房日";
                    }else{
                        str=str+","+"国际住房日";
                    }
                }
                if(shijiejianzhuri(year)==7){
                    if(str.equals("")){
                        str=str+"世界建筑日";
                    }else{
                        str=str+","+"世界建筑日";
                    }
                }
                return str;
            }
            if (day == 8) {
                String str = "全国高血压日";
                if(shijieshijueri(year)==8){
                    str=str+","+"世界视觉日";
                }
                if(guojijianzairi(year)==8){
                    str=str+","+"国际减灾日";
                }
                return str;
            }
            if (day == 9) {
                String str="世界邮政日";
                if(shijieshijueri(year)==9){
                    str=str+","+"世界视觉日";
                }
                if(guojijianzairi(year)==9){
                    str=str+","+"国际减灾日";
                }
                return str;
            }
            if (day == 10) {
                String str="世界精神卫生日";
                if(shijieshijueri(year)==10){
                    str=str+","+"世界视觉日";
                }
                if(guojijianzairi(year)==10){
                    str=str+","+"国际减灾日";
                }
                return str;
            }
            if (day == 11) {
                String str="国际女童日" + "," + "世界镇痛日";
                if(shijieshijueri(year)==11){
                    str=str+","+"世界视觉日";
                }
                if(guojijianzairi(year)==11){
                    str=str+","+"国际减灾日";
                }
                return str;
            }
            if (day == 12) {
                String str="国际关节炎日"+","+"世界60亿人口日";
                if(shijieshijueri(year)==12){
                    str=str+","+"世界视觉日";
                }
                if(guojijianzairi(year)==12){
                    str=str+","+"国际减灾日";
                }
                return str;
            }
            if (day == 13) {
                String str="世界保健日" + "," + "中国少年先锋队诞辰日"+","+"国际标准时间日";
                if(shijieshijueri(year)==13){
                    str=str+","+"世界视觉日";
                }
                if(guojijianzairi(year)==13){
                    str=str+","+"国际减灾日";
                }
                return str;
            }
            if (day == 14) {
                String str="世界标准日" +","+"葡萄酒情人节";
                if(shijieshijueri(year)==14){
                    str=str+","+"世界视觉日";
                }
                if(guojijianzairi(year)==14){
                    str=str+","+"国际减灾日";
                }
                return str;
            }
            if (day == 15) {
                return "国际盲人节" + "," + "世界洗手日"+","+"世界农村妇女日";
            }
            if (day == 16) {
                return "世界粮食日";
            }
            if (day == 17) {
                return "国际消除贫困日";
            }
            if (day == 18) {
                return "世界更年期关怀日";
            }
            if (day == 20) {
                return "世界厨师日" + "," + "世界骨质疏松日";
            }
            if (day == 22) {
                return "世界传统医药日";
            }
            if (day == 24) {
                return "联合国日" + "," + "世界发展宣传日";
            }
            if (day == 27) {
                return "世界音像遗产日";
            }
            if (day == 28) {
                return "中国男性健康日";
            }
            if (day == 29) {
                return "国际生物多样性日";
            }
            if (day == 31) {
                return "万圣节" + "," + "世界勤俭日";
            }

        } else if (month == 11) {
            if (day == 7) {
                return "十月革命纪念日";
            }
            if (day == 8) {
                return "中国记者节" + "," + "世界放射学日";
            }
            if (day == 9) {
                return "中国消防宣传日"+","+"吉尼斯世界纪录日";
            }
            if (day == 10) {
                return "世界青年节" + "," + "争取和平与发展世界科学日";
            }
            if (day == 11) {
                return "光棍节" + "," + "国际科学与和平周";
            }
            if (day == 14) {
                return "世界糖尿病日"+","+"电影情人节";
            }
            if(day==15){
                String str="";
                if(wordroadday(year)==15){
                    if(str.equals("")){
                        str=str+"世界道路交通事故受害者纪念日";
                    }else{
                        str=str+","+"世界道路交通事故受害者纪念日";
                    }
                }
                if(shijiezhexueri(year)==15){
                    if(str.equals("")){
                        str=str+"世界哲学日";
                    }else{
                        str=str+","+"世界哲学日";
                    }
                }
                return str;
            }
            if (day == 16) {
                String str="世界宽容日";
                if(wordroadday(year)==16){
                    str=str+","+"世界道路交通事故受害者纪念日";
                }
                if(shijiezhexueri(year)==16){
                    str=str+","+"世界哲学日";
                }
                return str;
            }
            if (day == 17) {
                String str="国际大学生日";
                if(wordroadday(year)==17){
                    str=str+","+"世界道路交通事故受害者纪念日";
                }
                if(shijiezhexueri(year)==17){
                    str=str+","+"世界哲学日";
                }
                return str;
            }
            if(day==18){
                String str="";
                if(wordroadday(year)==18){
                    if(str.equals("")){
                        str=str+"世界道路交通事故受害者纪念日";
                    }else{
                        str=str+","+"世界道路交通事故受害者纪念日";
                    }
                }
                if(shijiezhexueri(year)==18){
                    if(str.equals("")){
                        str=str+"世界哲学日";
                    }else{
                        str=str+","+"世界哲学日";
                    }
                }
                return str;
            }
            if(day==19){
                String str="世界厕所日";
                if(wordroadday(year)==19){
                    str=str+","+"世界道路交通事故受害者纪念日";
                }
                if(shijiezhexueri(year)==19){
                    str=str+","+"世界哲学日";
                }
                return str;
            }
            if (day == 20) {
                String str="非洲工业化日";
                if(wordroadday(year)==20){
                    str=str+","+"世界道路交通事故受害者纪念日";
                }
                if(shijiezhexueri(year)==20){
                    str=str+","+"世界哲学日";
                }
                return str;
            }
            if(day==21){
                String str="世界问候日";
                if(wordroadday(year)==21){
                    str=str+","+"世界道路交通事故受害者纪念日";
                }
                if(shijiezhexueri(year)==21) {
                    str=str+","+"世界哲学日";
                }
                return str;
            }
            if(day==22){
                String str="";
                if(thanksgiving(year)==22){
                    if(str.equals("")){
                        str=str+"感恩节";
                    }else{
                        str=str+","+"感恩节";
                    }
                }
                return str;
            }
            if(day==23){
                String str="";
                if(thanksgiving(year)==23){
                    if(str.equals("")){
                        str=str+"感恩节";
                    }else{
                        str=str+","+"感恩节";
                    }
                }
                return str;
            }
            if(day==24){
                String str="";
                if(thanksgiving(year)==24){
                    if(str.equals("")){
                        str=str+"感恩节";
                    }else{
                        str=str+","+"感恩节";
                    }
                }
                return str;
            }
            if (day == 25) {
                String str="国际消除对妇女的暴力日";
                if(thanksgiving(year)==25){
                    str=str+","+"感恩节";
                }
                return str;
            }
            if(day==26){
                String str="";
                if(thanksgiving(year)==26){
                    if(str.equals("")){
                        str=str+"感恩节";
                    }else{
                        str=str+","+"感恩节";
                    }
                }
                return str;
            }
            if(day==27){
                String str="";
                if(thanksgiving(year)==27){
                    if(str.equals("")){
                        str=str+"感恩节";
                    }else{
                        str=str+","+"感恩节";
                    }
                }
                return str;
            }
            if(day==28){
                String str="";
                if(thanksgiving(year)==28){
                    if(str.equals("")){
                        str=str+"感恩节";
                    }else{
                        str=str+","+"感恩节";
                    }
                }
                return str;
            }
            if (day == 29) {
                return "声援巴勒斯坦人民国际日";
            }

        } else if (month == 12) {
            if (day == 1) {
                return "世界艾滋病日";
            }
            if (day == 2) {
                return "废除奴隶制国际日";
            }
            if (day == 3) {
                return "国际残疾人日";
            }
            if (day == 4) {
                return "中国法制宣传日";
            }
            if (day == 5) {
                return "国际志愿人员日";
            }
            if (day == 7) {
                return "国际民航日";
            }
            if(day==8){
                String str="";
                if(guojiertongguangbo(year)==8){
                    if(str.equals("")){
                        str=str+"国际儿童广播电视节";
                    }else{
                        str=str+","+"国际儿童广播电视节";
                    }
                }
                return str;
            }
            if (day == 9) {
                String str="世界足球日" + "," + "国际反腐败日";
                if(guojiertongguangbo(year)==9){
                    str=str+","+"国际儿童广播电视节";
                }
                return str;
            }
            if (day == 10) {
                String str="世界人权日";
                if(guojiertongguangbo(year)==10){
                    str=str+","+"国际儿童广播电视节";
                }
                return str;
            }
            if (day == 11) {
                String str="国际山岳日";
                if(guojiertongguangbo(year)==11){
                    str=str+","+"国际儿童广播电视节";
                }
                return str;
            }
            if(day==12){
                String str="";
                if(guojiertongguangbo(year)==12){
                    if(str.equals("")){
                        str=str+"国际儿童广播电视节";
                    }else{
                        str=str+","+"国际儿童广播电视节";
                    }
                }
                return str;
            }
            if (day == 13) {
                String str="南京大屠杀纪念日";
                if(guojiertongguangbo(year)==13){
                    str=str+","+"国际儿童广播电视节";
                }
                return str;
            }
            if(day==14){
                String str="拥抱情人节";
                if(guojiertongguangbo(year)==14){
                    str=str+","+"国际儿童广播电视节";
                }
                return str;
            }
            if (day == 15) {
                return "世界强化免疫日";
            }
            if (day == 18) {
                return "国际移徙者日";
            }
            if (day == 20) {
                return "阔时节" + "," + "国际人类团结日" + "," + "澳门回归纪念日";
            }
            if (day == 21) {
                return "国际篮球节";
            }
            if (day == 24) {
                return "平安夜";
            }
            if (day == 25) {
                return "圣诞节";
            }
            if (day == 29) {
                return "国际生物多样性日";
            }
        }
        return "";
    }

    public static String getLunarHoliday(String month, String day, String sum, String pchuxi) {

        if ((month.equals("一") && day.equals("初一")) || sum.equals("一月初一")) {
            return "春节";
        } else if ((month.equals("一") && day.equals("初二")) || sum.equals("一月初二")) {
            return "苗族花山节";
        } else if ((month.equals("一") && day.equals("十五")) || sum.equals("一月十五")) {
            return "元宵节" + "," + "木脑纵歌";
        } else if ((month.equals("二") && day.equals("初一")) || sum.equals("二月初一")) {
            return "中和日";
        } else if ((month.equals("二") && day.equals("初二")) || sum.equals("二月初二")) {
            return "龙抬头节";
        } else if ((month.equals("二") && day.equals("十二")) || sum.equals("二月十二")) {
            return "花朝节";
        } else if ((month.equals("二") && day.equals("十九")) || sum.equals("二月十九")) {
            return "观音菩萨生日";
        } else if ((month.equals("三") && day.equals("初三")) || sum.equals("三月初三")) {
            return "上巳节";
        } else if ((month.equals("三") && day.equals("初十")) || sum.equals("三月初十")) {
            return "白族三月街";
        } else if ((month.equals("四") && day.equals("初八")) || sum.equals("四月初八")) {
            return "佛诞节";
        } else if ((month.equals("四") && day.equals("十三")) || sum.equals("四月十三")) {
            return "傣族泼水节";
        } else if ((month.equals("五") && day.equals("初五")) || sum.equals("五月初五")) {
            return "端午节";
        } else if ((month.equals("六") && day.equals("十九")) || sum.equals("六月十九")) {
            return "观音成道日";
        } else if ((month.equals("六") && day.equals("廿四")) || sum.equals("六月廿四")) {
            return "观莲节" + "," + "哈尼族苦扎扎节" + "," + "火把节";
        } else if ((month.equals("七") && day.equals("初七")) || sum.equals("七月初七")) {
            return "乞巧节";
        } else if ((month.equals("七") && day.equals("十五")) || sum.equals("七月十五")) {
            return "中元节";
        } else if ((month.equals("七") && day.equals("卅十")) || sum.equals("七月卅十")) {
            return "地藏节";
        } else if ((month.equals("八") && day.equals("十五")) || sum.equals("八月十五")) {
            return "中秋节";
        } else if ((month.equals("九") && day.equals("初九")) || sum.equals("九月初九")) {
            return "重阳节";
        } else if ((month.equals("九") && day.equals("十九")) || sum.equals("九月十九")) {
            return "观音出家日";
        } else if ((month.equals("十") && day.equals("初一")) || sum.equals("十月初一")) {
            return "祭祖节";
        } else if ((month.equals("十二") && day.equals("初八")) || sum.equals("十二月初八")) {
            return "腊八节";
        } else if ((month.equals("十二") && day.equals("廿三")) || sum.equals("十二月廿三")) {
            return "小年";
        } else if (pchuxi.equals("十二月廿九")) {
            return "除夕";
        } else if (pchuxi.equals("十二月卅十")) {
            return "除夕";
        }

        return "";
    }

    /**
     * 特殊的节日
     */

    /**
     * 国际麻风节,1月的最后一个星期天
     * 它只会出现在1月的25,26,27,28,29,30,31这几天
     * @param year
     * @return
     */
    public static int getlastweekmafeng(int year) {
        Calendar instance = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd");
        instance.set(Calendar.YEAR, year);
        instance.set(Calendar.MONTH,1);// 月份
        instance.set(Calendar.DAY_OF_MONTH, 1);// 天设为下一个月的第一天
        instance.add(Calendar.DAY_OF_MONTH, -1);// 本月最后一天
        instance.add(Calendar.DAY_OF_MONTH, 1 - instance
                .get(Calendar.DAY_OF_WEEK));// 根据月末最后一天是星期几，向前偏移至最近的周日
        String time = format.format(instance.getTime());
        String[] ss = time.split("-");
        return Integer.parseInt(ss[2]);
    }

    /**
     *国际聋人节,9月的最后一个星期天
     *它只会出现在9月的24,25,26,27,28,29,30这几天
     * @param year
     * @return
     */
    public static int getlastweeklongren(int year) {
        Calendar instance = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd");
        instance.set(Calendar.MONTH,9);// 月份
        instance.set(Calendar.YEAR, year);
        instance.set(Calendar.DAY_OF_MONTH, 1);// 天设为下一个月的第一天
        instance.add(Calendar.DAY_OF_MONTH, -1);// 本月最后一天
        instance.add(Calendar.DAY_OF_MONTH, 1 - instance
                .get(Calendar.DAY_OF_WEEK));// 根据月末最后一天是星期几，向前偏移至最近的周日
        String time = format.format(instance.getTime());
        String[] ss = time.split("-");
        return Integer.parseInt(ss[2]);
    }

    /**
     * 地球一小时，3月的最后一个周六
     * 它只会出现在3月的25,26,27,28,29,30,31这几天
     * @param year
     * @return
     */
    public static int diqiuyixiaoshi(int year) {
        int count=0;
        Calendar instance = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd");
        instance.set(Calendar.YEAR, year);
        instance.set(Calendar.MONTH,3);// 月份
        instance.set(Calendar.DAY_OF_MONTH, 1);// 天设为下一个月的第一天
        instance.add(Calendar.DAY_OF_MONTH, -1);// 本月最后一天
        count=instance.get(Calendar.DAY_OF_WEEK);
        if(count==7){
            count=0;
        }
        instance.add(Calendar.DAY_OF_MONTH, - count);
        String time = format.format(instance.getTime());
        String[] ss = time.split("-");
        return Integer.parseInt(ss[2]);
    }

    /**
     * 全国中小学生安全教育日，3月的最后一个周一
     * 它只会出现在3月的25,26,27,28,29,30,31这几天
     * @param year
     * @return
     */
    public static int safeeducation(int year) {
        int count=0;
        int count1=0;
        Calendar instance = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd");
        instance.set(Calendar.YEAR, year);
        instance.set(Calendar.MONTH,3);// 月份
        instance.set(Calendar.DAY_OF_MONTH, 1);// 天设为下一个月的第一天
        instance.add(Calendar.DAY_OF_MONTH, -1);// 本月最后一天
        count = instance.get(Calendar.DAY_OF_WEEK);
        count1=(-5- count)%7;
        if(count==2){
            count1=0;
        }
        instance.add(Calendar.DAY_OF_MONTH, count1);
        String time = format.format(instance.getTime());
        String[] ss = time.split("-");
        return Integer.parseInt(ss[2]);
    }
    /**
     * 全国中小学生安全教育日，9月的最后一周，按照周一算
     * 它只会出现在9月的24,25,26,27,28,29,30这几天
     * @param year
     * @return
     */
    public static int shijiehaishiri(int year) {
        int count=0;
        int count1=0;
        Calendar instance = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd");
        instance.set(Calendar.YEAR, year);
        instance.set(Calendar.MONTH,9);// 月份
        instance.set(Calendar.DAY_OF_MONTH, 1);// 天设为下一个月的第一天
        instance.add(Calendar.DAY_OF_MONTH, -1);// 本月最后一天
        count = instance.get(Calendar.DAY_OF_WEEK);
        count1=(-5- count)%7;
        if(count==2){
            count1=0;
        }
        instance.add(Calendar.DAY_OF_MONTH, count1);
        String time = format.format(instance.getTime());
        String[] ss = time.split("-");
        return Integer.parseInt(ss[2]);
    }

    /**
     * 父亲节，每年6月的第三个星期天
     * 它只会在6月的15,16,17,18,19,20，21这几天
     * @param year
     * @return
     */
    public static int fatherday(int year) {
        int count=0;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd");
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, 5);// 月份-1
        calendar.set(Calendar.DAY_OF_MONTH, 1);// 天设为下一个月的第一天
        count=calendar.get(Calendar.DAY_OF_WEEK)-1;
        System.out.println(count);
        count=(7-count);
        if(count==7){
            count=0;
        }
        calendar.add(Calendar.DAY_OF_WEEK, count + 14);
        String time = format.format(calendar.getTime());

        String[] ss = time.split("-");
        return Integer.parseInt(ss[2]);
    }

    /**
     * 全国助残日 5月的第三个星期天
     * 它只会在5月的15,16,17,18,19,20,21这几天
     * @param year
     * @return
     */
    public static int quanguozhucanri(int year) {
        int count=0;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd");
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, 4);// 月份-1
        calendar.set(Calendar.DAY_OF_MONTH, 1);// 天设为下一个月的第一天
        count=calendar.get(Calendar.DAY_OF_WEEK)-1;
        System.out.println(count);
        count=(7-count);
        if(count==7){
            count=0;
        }
        calendar.add(Calendar.DAY_OF_WEEK, count + 14);
        String time = format.format(calendar.getTime());

        String[] ss = time.split("-");
        return Integer.parseInt(ss[2]);
    }

    /**
     * 世界道路交通事故受害者纪念日,11月的第三个星期天
     * 他只会在11月的15,16,17,18,19,20,21这几天
     * @param year
     * @return
     */
    public static int wordroadday(int year) {
        int count=0;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd");
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, 10);// 月份-1
        calendar.set(Calendar.DAY_OF_MONTH, 1);// 天设为下一个月的第一天
        count=calendar.get(Calendar.DAY_OF_WEEK)-1;
        System.out.println(count);
        count=(7-count);
        if(count==7){
            count=0;
        }
        calendar.add(Calendar.DAY_OF_WEEK, count + 14);
        String time = format.format(calendar.getTime());

        String[] ss = time.split("-");
        return Integer.parseInt(ss[2]);
    }

    /**
     * 世界清洁地球日,9月的第三个星期天
     * 他只会在9月的15,16,17,18,19,20,21这几天
     * @param year
     * @return
     */
    public static int shijieqingjiediqiuri(int year) {
        int count=0;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd");
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, 8);// 月份-1
        calendar.set(Calendar.DAY_OF_MONTH, 1);// 天设为下一个月的第一天
        count=calendar.get(Calendar.DAY_OF_WEEK)-1;
        System.out.println(count);
        count=(7-count);
        if(count==7){
            count=0;
        }
        calendar.add(Calendar.DAY_OF_WEEK, count + 14);
        String time = format.format(calendar.getTime());

        String[] ss = time.split("-");
        return Integer.parseInt(ss[2]);
    }

    /**
     * 全民国防教育日,9月的第三个周六
     * 它只会在9月的15,16,17,18,19,20,21这几天
     * @param year
     * @return
     */
    public static int quanminguofang(int year) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH,8);
        calendar.set(Calendar.WEEK_OF_YEAR, 1);
        calendar.set(Calendar.WEEK_OF_MONTH, 3);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        String time = format.format(calendar.getTime());
        String[] ss = time.split("-");
        return Integer.parseInt(ss[2]);
    }
    /**
     * 全国科普日,9月的第三个双休日，暂时只在周六呈现，具体节日介绍里说明
     * 它只会在9月的15,16,17,18,19,20,21这几天
     * @param year
     * @return
     */
    public static int quanminkepu(int year) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,8);
        calendar.set(Calendar.WEEK_OF_YEAR,1);
        calendar.set(Calendar.WEEK_OF_MONTH,3);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        String time = format.format(calendar.getTime());
        String[] ss = time.split("-");
        return Integer.parseInt(ss[2]);
    }

    /**
     * 世界肾脏日,3月第二个星期四
     * 3月的8,9,10,11,12,13,14这几天
     * @param year
     * @return
     */
    public static int shijieshenzangri(int year) {
        int count=0;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd");
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH,2);// 月份-1
        calendar.set(Calendar.DAY_OF_MONTH, 1);// 天设为下一个月的第一天
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        count=calendar.get(Calendar.DAY_OF_WEEK)-1;
        System.out.println(count);
        count=(11-count)%7;
        calendar.add(Calendar.DAY_OF_WEEK, count + 7);
        String time = format.format(calendar.getTime());
        String[] ss = time.split("-");
        return Integer.parseInt(ss[2]);
    }

    /**
     * 4月第四个星期日世界儿童日
     * 22,23,24,25,26,27,28
     * @param year
     * @return
     */
    public static int shijieritongri(int year) {
        int count=0;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd");
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, 3);// 月份-1
        calendar.set(Calendar.DAY_OF_MONTH, 1);// 天设为下一个月的第一天
        count=calendar.get(Calendar.DAY_OF_WEEK)-1;
        System.out.println(count);
        count=(7-count);
        if(count==7){
            count=0;
        }
        calendar.add(Calendar.DAY_OF_WEEK, count + 21);
        String time = format.format(calendar.getTime());

        String[] ss = time.split("-");
        return Integer.parseInt(ss[2]);
    }
    /**
     * 5月第二个星期六世界候鸟日
     * 8,9,10,11,12,13,14
     */
    public static int houliaori(int year) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH,4);//月份-1
        calendar.set(Calendar.WEEK_OF_YEAR, 1);
        calendar.set(Calendar.WEEK_OF_MONTH, 2);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        String time = format.format(calendar.getTime());
        String[] ss = time.split("-");
        return Integer.parseInt(ss[2]);
    }

    /**
     * 6月第二个星期六中国文化遗产日
     * 8,9,10,11,12,13,14
     * @param year
     * @return
     */
    public static int zhongguowenhuayichan(int year) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH,5);//月份-1
        calendar.set(Calendar.WEEK_OF_YEAR,1);
        calendar.set(Calendar.WEEK_OF_MONTH, 2);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        String time = format.format(calendar.getTime());
        String[] ss = time.split("-");
        return Integer.parseInt(ss[2]);
    }

    /**
     * 7月第一个星期六国际合作社日
     * 1,2,3,4,5,6,7
     * @param year
     * @return
     */
    public static int guojihezuosheri(int year) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH,6);//月份-1
        calendar.set(Calendar.WEEK_OF_YEAR,1);
        calendar.set(Calendar.WEEK_OF_MONTH, 1);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        String time = format.format(calendar.getTime());
        String[] ss = time.split("-");
        return Integer.parseInt(ss[2]);
    }

    /**
     * 9月第二个星期六世界急救日
     * 8,9,10,11,12,13,14
     * @param year
     * @return
     */
    public static int shijiejijiuri(int year) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH,8);//月份-1
        calendar.set(Calendar.WEEK_OF_YEAR,1);
        calendar.set(Calendar.WEEK_OF_MONTH, 2);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        String time = format.format(calendar.getTime());
        String[] ss = time.split("-");
        return Integer.parseInt(ss[2]);
    }

    /**
     * 10月第一个星期六世界临终关怀及舒缓治疗日
     * 1,2,3,4,5,6,7
     * @param year
     * @return
     */
    public static int shijielinzhongguanhuai(int year) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH,9);//月份-1
        calendar.set(Calendar.WEEK_OF_YEAR,1);
        calendar.set(Calendar.WEEK_OF_MONTH, 1);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        String time = format.format(calendar.getTime());
        String[] ss = time.split("-");
        return Integer.parseInt(ss[2]);
    }

    /**
     *5月第二个星期天母亲节
     * 8,9,10,11,12,13,14
     * @param year
     * @return
     */
    public static int motherday(int year) {
        int count=0;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd");
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, 4);// 月份-1
        calendar.set(Calendar.DAY_OF_MONTH, 1);// 天设为下一个月的第一天
        count=calendar.get(Calendar.DAY_OF_WEEK)-1;
        System.out.println(count);
        count=(7-count)%7;
        calendar.add(Calendar.DAY_OF_WEEK, count + 7);
        String time = format.format(calendar.getTime());

        String[] ss = time.split("-");
        return Integer.parseInt(ss[2]);
    }

    /**
     * 12月第二个星期日国际儿童广播电视节
     * 8,9,10,11,12,13,14
     * @param year
     * @return
     */
    public static int guojiertongguangbo(int year) {
        int count=0;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd");
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, 11);// 月份-1
        calendar.set(Calendar.DAY_OF_MONTH, 1);// 天设为下一个月的第一天
        count=calendar.get(Calendar.DAY_OF_WEEK)-1;
        System.out.println(count);
        count=(7-count)%7;
        calendar.add(Calendar.DAY_OF_WEEK, count + 7);
        String time = format.format(calendar.getTime());

        String[] ss = time.split("-");
        return Integer.parseInt(ss[2]);
    }
    /**
     * 4月第二或第三个星期日，全球青年服务日，默认第2个
     * 8,9,10,11,12,13,14
     * @param year
     * @return
     */
    public static int quanqiuqingnianfuwuri(int year) {
        int count=0;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd");
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, 3);// 月份-1
        calendar.set(Calendar.DAY_OF_MONTH, 1);// 天设为下一个月的第一天
        count=calendar.get(Calendar.DAY_OF_WEEK)-1;
        System.out.println(count);
        count=(7-count)%7;
        calendar.add(Calendar.DAY_OF_WEEK, count + 7);
        String time = format.format(calendar.getTime());

        String[] ss = time.split("-");
        return Integer.parseInt(ss[2]);
    }

    /**
     *10月第一个星期一国际住房日
     * 1,2,3,4,5,6,7
     * @param year
     * @return
     */
    public static int guojizhufangri(int year) {
        int count=0;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd");
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH,9);// 月份-1
        calendar.set(Calendar.DAY_OF_MONTH, 1);// 天设为下一个月的第一天
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        count=calendar.get(Calendar.DAY_OF_WEEK)-1;
        System.out.println(count);
        count=(8-count)%7;
        calendar.add(Calendar.DAY_OF_WEEK, count);
        String time = format.format(calendar.getTime());
        String[] ss = time.split("-");
        return Integer.parseInt(ss[2]);
    }

    /**
     * 10月第一个星期一世界建筑日
     * 1,2,3,4,5,6,7
     * @param year
     * @return
     */
    public static int shijiejianzhuri(int year) {
        int count=0;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd");
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH,9);// 月份-1
        calendar.set(Calendar.DAY_OF_MONTH, 1);// 天设为下一个月的第一天
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        count=calendar.get(Calendar.DAY_OF_WEEK)-1;
        System.out.println(count);
        count=(8-count)%7;
        calendar.add(Calendar.DAY_OF_WEEK, count);
        String time = format.format(calendar.getTime());
        String[] ss = time.split("-");
        return Integer.parseInt(ss[2]);
    }

    /**
     * 10月第二个星期四世界视觉日
     * 8,9,10,11,12,13,14
     * @param year
     * @return
     */
    public static int shijieshijueri(int year) {
        int count=0;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd");
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH,9);// 月份-1
        calendar.set(Calendar.DAY_OF_MONTH, 1);// 天设为下一个月的第一天
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        count=calendar.get(Calendar.DAY_OF_WEEK)-1;
        System.out.println(count);
        count=(11-count)%7;
        calendar.add(Calendar.DAY_OF_WEEK, count + 7);
        String time = format.format(calendar.getTime());
        String[] ss = time.split("-");
        return Integer.parseInt(ss[2]);
    }

    /**
     * 11月第三个星期四世界哲学日
     * 15,16,17,18,19,20,21
     * @param year
     * @return
     */
    public static int shijiezhexueri(int year) {
        int count=0;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd");
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH,10);// 月份-1
        calendar.set(Calendar.DAY_OF_MONTH, 1);// 天设为下一个月的第一天
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        count=calendar.get(Calendar.DAY_OF_WEEK)-1;
        System.out.println(count);
        count=(11-count)%7;
        calendar.add(Calendar.DAY_OF_WEEK, count +14);
        String time = format.format(calendar.getTime());
        String[] ss = time.split("-");
        return Integer.parseInt(ss[2]);
    }

    /**
     * 11月第四个星期四感恩节
     * 22,23,24,25,26,27,28
     * @param year
     * @return
     */
    public static int thanksgiving(int year) {
        int count=0;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd");
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH,10);// 月份-1
        calendar.set(Calendar.DAY_OF_MONTH, 1);// 天设为下一个月的第一天
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        count=calendar.get(Calendar.DAY_OF_WEEK)-1;
        System.out.println(count);
        count=(11-count)%7;
        calendar.add(Calendar.DAY_OF_WEEK, count +21);
        String time = format.format(calendar.getTime());
        String[] ss = time.split("-");
        return Integer.parseInt(ss[2]);
    }

    /**
     * 5月第一周的周二世界哮喘日
     * 1,2,3,4,5,6,7
     * @param year
     * @return
     */
    public static int shijiexiaochuanri(int year) {
        int count=0;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd");
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH,4);// 月份-1
        calendar.set(Calendar.DAY_OF_MONTH, 1);// 天设为下一个月的第一天
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        count=calendar.get(Calendar.DAY_OF_WEEK)-1;
        System.out.println(count);
        count=(9-count)%7;
        calendar.add(Calendar.DAY_OF_WEEK, count);
        String time = format.format(calendar.getTime());
        String[] ss = time.split("-");
        return Integer.parseInt(ss[2]);
    }

    /**
     * 10月第二个星期三国际减灾日
     * 8,9,10,11,12,13,14
     * @param year
     * @return
     */
    public static int guojijianzairi(int year) {
        int count=0;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd");
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH,9);// 月份-1
        calendar.set(Calendar.DAY_OF_MONTH, 1);// 天设为下一个月的第一天
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        count=calendar.get(Calendar.DAY_OF_WEEK)-1;
        System.out.println(count);
        count=(10-count)%7;
        calendar.add(Calendar.DAY_OF_WEEK, count +7);
        String time = format.format(calendar.getTime());
        String[] ss = time.split("-");
        return Integer.parseInt(ss[2]);
    }

    /**
     * 世界居住条件调查日,2月的最后一天
     * 28，29
     * @param year
     * @return
     */
    public static int gettwomonthlastday(int year) {
        Calendar instance = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd");
        instance.set(Calendar.YEAR, year);
        instance.set(Calendar.MONTH, 2);// 月份+1
        instance.set(Calendar.DAY_OF_MONTH, 1);// 天设为下一个月的第一天
        instance.add(Calendar.DAY_OF_MONTH, -1);// 本月最后一天
        String time = format.format(instance.getTime());
        String[] ss = time.split("-");
        return  Integer.parseInt(ss[2]);
    }

    /**
     * 国际秘书日,4月最后一个完整的一周中的周三
     * 21,22,23,24,25,26,27
     * @param year
     * @return
     */
    public static int guojimishuri(int year) {
        Calendar instance = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd");
        instance.set(Calendar.YEAR, year);
        instance.set(Calendar.MONTH,4);// 月份
        instance.set(Calendar.DAY_OF_MONTH, 1);// 天设为下一个月的第一天
        instance.add(Calendar.DAY_OF_MONTH, -1);// 本月最后一天
        instance.add(Calendar.DAY_OF_MONTH, 1- instance.get(Calendar.DAY_OF_WEEK)-4);// 根据月末最后一天是星期几，向前偏移至最近的周日
        String time = format.format(instance.getTime());
        String[] ss = time.split("-");
        return  Integer.parseInt(ss[2]);
    }



}
