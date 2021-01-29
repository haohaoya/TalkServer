package view;

public class Chat {
    private String head;
    private StringBuilder message;
    private String tail;
    private String userName;
    private boolean refrushOrNot;
    public Chat(String userName){
        this.userName = userName;
        this.head = new String("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>浩浩聊天室</title>\n" +
                "    <style>\n" +
                "        * {\n" +
                "\t\t\tmargin: 0;\n" +
                "\t\t\tpadding: 0;\n" +
                "\t\t}\n" +
                "\t\thtml,body {\n" +
                "\t\t\twidth: 100%;\n" +
                "\t\t\theight: 100%;\n" +
                "\t\t}\n" +
                "\t\tbody{\n" +
                "\t\t\tbackground:url(http://img95.699pic.com/photo/40006/2210.jpg_wh300.jpg) center center;\n" +
                "\t\t\tbackground-size: auto;\n" +
                "\t\t\tbackground-attachment: scroll;\n" +
                "\t\t\tanimation: move 8s linear infinite;\n" +
                "\t\t}\n" +
                "\t\t@keyframes move {\n" +
                "\t\t\t0% {\n" +
                "\t\t\t\tbackground-position-x: 15px; \n" +
                "\t\t\t}\n" +
                "\t\t\t25% {\n" +
                "\t\t\t\tbackground-position-x: -5px; \n" +
                "\t\t\t}\n" +
                "\t\t\t100% {\n" +
                "\t\t\t\tbackground-position-x: 15px;\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t\t.box {\n" +
                "\t\t\tposition: fixed;\n" +
                "\t\t\ttop: 50%;\n" +
                "\t\t\tleft: 50%;\n" +
                "\t\t\ttransform: translate(-50%,-50%);\n" +
                "\t\t\twidth: 56%;\n" +
                "\t\t\theight: 96%;\n" +
                "\t\t\tborder-radius: 4%;\n" +
                "\t\t\tbackground-color: rgba(171, 212, 231, 0.171);\n" +
                "\t\t}\n" +
                "\t\t.box-top {\n" +
                "\t\t\tposition: relative;\n" +
                "\t\t\toverflow-x: hidden;\n" +
                "\t\t\toverflow-y: scroll;\n" +
                "\t\t\ttransform: translateY(13px);\n" +
                "\t\t\twidth: 95%;\n" +
                "\t\t\theight: 70%;\n" +
                "\t\t\tmargin: 5px auto;\n" +
                "\t\t\tbackground-color: rgba(124, 167, 192, 0.253);\n" +
                "\t\t}\n" +
                "\t\t.box-bottom {\n" +
                "\t\t\twidth: 95%;\n" +
                "\t\t\theight: 20%;\n" +
                "\t\t\tmargin: 27px auto;\n" +
                "\t\t\tbackground-color: rgba(161, 197, 218, 0.253);\n" +
                "\t\t}\n" +
                "\t\ttextarea {\n" +
                "\t\t\ttransition: all 1s;\n" +
                "\t\t\tfont-size: 18px;\n" +
                "\t\t\tresize: none;\n" +
                "\t\t\twidth: 100%;\n" +
                "\t\t\theight: 138%;\n" +
                "\t\t\tbackground-color: rgba(109, 149, 172, 0);\n" +
                "\t\t\tborder-color: rgba(0, 0, 0, 0); \n" +
                "\t\t}\n" +
                "\t\tform {\n" +
                "\t\t\twidth: 100%;\n" +
                "\t\t\theight: 50%;\n" +
                "\t\t}\n" +
                "\t\tinput {\n" +
                "\t\t\tmargin: 0 12px 0 0 ;\n" +
                "\t\t\twidth: 59px;\n" +
                "\t\t\theight: 29px;\n" +
                "\t\t\tbox-shadow:0px 0px 5px rgba(165, 159, 221, 2.63); \n" +
                "\t\t\tfloat: right;\n" +
                "\t\t\tborder-radius: 4%;\n" +
                "\t\t\tborder-color: rgba(247, 125, 125, 0);\n" +
                "\t\t\tbackground-color: rgba(104, 160, 192, 0.603);\n" +
                "\t\t\tcursor: pointer;\n" +
                "\t\t}\n" +
                "\t\ttextarea:focus {\n" +
                "\t\t\tbox-shadow: 0px 0px 8px rgb(200, 218, 252); \n" +
                "\t\t}\n" +
                "\t\tinput:hover {\n" +
                "\t\t\tbox-shadow:0px 0px 8px rgb(255, 255, 255); \n" +
                "\t\t}\n" +
                "\t\t.box-top::-webkit-scrollbar,.sHistory::-webkit-scrollbar{/*滚动条整体部分，其中的属性有width,height,background,border等（就和一个块级元素一样）（位置1）*/\n" +
                "\t\t\twidth:12px;\n" +
                "\t\t\theight:10px;\n" +
                "\t\t}\n" +
                "\t\t.box-top::-webkit-scrollbar-button,.sHistory::-webkit-scrollbar-button{/*滚动条两端的按钮，可以用display:none让其不显示，也可以添加背景图片，颜色改变显示效果（位置2）*/\n" +
                "\t\t\tbackground:rgba(56, 66, 83, 0.61);\n" +
                "\t\t}\n" +
                "\t\t.box-top::-webkit-scrollbar-track,.sHistory::-webkit-scrollbar-track{/*外层轨道，可以用display:none让其不显示，也可以添加背景图片，颜色改变显示效果（位置3）*/\n" +
                "\t\t\tbackground:rgba(86, 135, 180, 0.568);\n" +
                "\t\t}\n" +
                "\t\t.box-top::-webkit-scrollbar-track-piece,.sHistory::-webkit-scrollbar-track-piece{/*内层轨道，滚动条中间部分（位置4）*/\n" +
                "\t\t\tbackground:rgba(41, 47, 58, 0.295);\n" +
                "\t\t}\n" +
                "\t\t.box-top::-webkit-scrollbar-thumb,.sHistory::-webkit-scrollbar-thumb{/*滚动条里面可以拖动的那部分（位置5）*/\n" +
                "\t\t\tbackground:rgb(47, 63, 87);\n" +
                "\t\t\tborder-radius:4px;\n" +
                "\t\t}\n" +
                "\t\t.box-top::-webkit-scrollbar-corner,.sHistory::-webkit-scrollbar-corner {/*边角（位置6）*/\n" +
                "\t\t\tbackground:rgba(67, 85, 117, 0.555); \n" +
                "\t\t}\n" +
                "\t\t.box-top::-webkit-scrollbar-resizer,.sHistory::-webkit-scrollbar-resizer  {/*定义右下角拖动块的样式（位置7）*/\n" +
                "\t\t\tbackground:rgba(51, 58, 71, 0.432);\n" +
                "\t\t}\n" +
                "\t\t.new {\n" +
                "\t\t\tcolor: rgba(240, 255, 255, 0.548);\n" +
                "\t\t\ttext-align: center;\n" +
                "\t\t\tfont-size: 14px;\n" +
                "\t\t\tmargin: 8px auto;\n" +
                "\t\t\twidth: 233px;\n" +
                "\t\t\theight: 21px;\n" +
                "\t\t\tbackground-color: rgba(19, 27, 36, 0.459);\n" +
                "\t\t\tborder-radius: 5px;\n" +
                "\t\t}\n" +
                "\t\timg {\n" +
                "\t\t\tmin-width: 45px;\n" +
                "\t\t\tmax-width: 45px;\n" +
                "\t\t\tmax-height: 45px;\n" +
                "\t\t\tdisplay: block;\n" +
                "\t\t\tposition: relative;\n" +
                "\t\t\ttop: -20px;\n" +
                "\t\t\tright: 0px;\n" +
                "\t\t\twidth: 45px;\n" +
                "\t\t\theight: 45px;\n" +
                "\t\t\tborder-radius: 45px;\n" +
                "\t\t}\n" +
                "\t\t.aaa-r,.aaa-l,.s-aaa-r,.s-aaa-l  { \n" +
                "\t\t\tposition: relative;\n" +
                "\t\t\tdisplay: inline-flex;\n" +
                "\t\t\tmax-width: 79%;\n" +
                "\t\t\tpadding: 25px 0 10px 0;\n" +
                "\t\t}\n" +
                "\t\t.aaa-r,.s-aaa-r {\n" +
                "\t\t\tfloat: right;\n" +
                "\t\t}\n" +
                "\t\t.aa2,.aa1 {\n" +
                "\t\t\tdisplay: inline-block;\n" +
                "\t\t\tpadding: 5px 9px 5px 9px;\n" +
                "\t\t\tline-height: 2em;\n" +
                "\t\t\tcolor: azure;\n" +
                "\t\t\tbackground-color: rgba(23, 33, 53, 0.747);\n" +
                "\t\t\tborder-radius: 17px;\n" +
                "\t\t}\n" +
                "\t\t.aa2 {\n" +
                "\t\t\ttext-align: left;\n" +
                "\t\t}\n" +
                "\t\t.name-l {\n" +
                "\t\t\tfont-size: 14px;\n" +
                "\t\t\tcolor: azure;\n" +
                "\t\t\tposition: absolute;\n" +
                "\t\t\ttop: 5px;\n" +
                "\t\t\tleft: 64px;\n" +
                "\t\t}\n" +
                "\n" +
                "\t\t.name-r {\n" +
                "\t\t\tfont-size: 14px;\n" +
                "\t\t\tcolor: azure;\n" +
                "\t\t\tposition: absolute;\n" +
                "\t\t\ttop: 5px;\n" +
                "\t\t\tright: 64px;\n" +
                "\t\t}\n" +
                "\n" +
                "\t\t.s-aaa-l p,.s-aaa-r p {\n" +
                "\t\t\tcolor: rgb(255, 255, 255);\n" +
                "\t\t\tbackground: url(data:image/jpeg;base64,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);\n" +
                "\t\t\tbackground-position: left;\n" +
                "\t\t\tbackground-repeat: repeat;\n" +
                "\t\t\tdisplay: inline;\n" +
                "\t\t\tfloat: left;\n" +
                "\t\t\tbackground-size: cover;\n" +
                "\t\t\topacity: 0.8;\n" +
                "\t\t\tanimation: go 6s linear infinite;\n" +
                "\t\t\tborder: 1px solid rgba(134, 198, 241, 0.849);\n" +
                "\t\t} \n" +
                "\t\t@keyframes go {\n" +
                "\t\t\t0% {\n" +
                "\t\t\t\tbackground-position: 0 0px;\n" +
                "\t\t\t\tbox-shadow: 1px 1px 5px rgba(176, 180, 219, 0.445);\n" +
                "\t\t\t}\n" +
                "\t\t\t25% {\n" +
                "\t\t\t\tbackground-position: 0 -13px;\n" +
                "\t\t\t\tbox-shadow: 1px 1px 9px rgba(194, 199, 238, 0.836);\n" +
                "\t\t\t}\n" +
                "\t\t\t100% {\n" +
                "\t\t\t\tbackground-position: 0 0px;\n" +
                "\t\t\t\tbox-shadow: 1px 1px 5px rgba(176, 180, 219, 0.445);\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t\t.box1 {\n" +
                "\t\t\twidth: 100%;\n" +
                "\t\t\tdisplay: inline-block;\n" +
                "\t\t}\n" +
                "\t\tp {\n" +
                "\t\t\tmin-height: 17px;\n" +
                "\t\t}\n" +
                "    </style>\n" +
                "\t<script>\n" +
                "        function remove() {\n" +
                "\t\t\tsessionStorage.removeItem(\"mycache\");\n" +
                "        }\n" +
                "    </script> \n" +
                "</head>\n" +
                "<body>\n" +
                "\t<script>\n" +
                "var url = location.search;\n" +
                "\t\tif (url.indexOf(\"?\") != -1) {\n" +
                "\t\t\tvar str = url.substr(1);\n" +
                "\t\t\tstrs = str.split(\"=\");\n" +
                "\t\t\tencoder = new TextEncoder('utf8');\n" +
                "\t\t\tif(!(sessionStorage.getItem(\"user\")==encoder.encode(strs[1])])){\n" +
                "\t\t\t\twindow.location.href=\"/NotFound\"; \n" +
                "\t\t\t}\n" +
                "\t\t}else{\n" +
                "\t\t\twindow.location.href=\"/NotFound\";\n" +
                "\t\t}" +
                "\t</script>\n" +
                "    <div class=\"box\">  \n" +
                "        <div class=\"box-top\">");
        this.message = new StringBuilder("");
        this.tail = new String("        </div>\n" +
                "        <div class=\"box-bottom\">\n" +
                "            <form  method=\"POST\">\n" +
                "            <textarea id=\"message\" autocomplete=\"on\" name=\"message\" cols=\"30\" rows=\"0\"></textarea>\n" +
                "            <input type=\"submit\" value=\"发送\" onclick=\"remove()\">\n" +
                "        </form>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "    <script>\n" +
                "            if(sessionStorage.getItem(\"mycache\") != null){\n" +
                "                document.getElementById(\"message\").innerText = sessionStorage.getItem(\"mycache\");\n" +
                "            }\n" +
                "            setInterval(function(){ \n" +
                "                sessionStorage.setItem(\"mycache\",document.getElementById(\"message\").value);\n" +
                "\n" +
                "\t\t\t\tvar url = window.location.href;\n" +
                "\t\t\t\twindow.location.href=url; " +
                "            },3000);\n" +
                "    </script>\n" +
                "</body>\n" +
                "</html>");
        this.addSystemMessage(userName+" 加入了聊天室");
        this.refrushOrNot = false;
    }

    public void addSystemMessage(String str){
        String finalStr = "<div class=\"new\">"+str+"</div>";
        message.append(finalStr);
        this.refrushOrNot = true;
    }

    public void addSpecialMessage(String name,String str){
        StringBuilder finalStr = new StringBuilder("");
        if(this.userName.equals(name)){
            finalStr.append("            <div class=\"box1\">\n" +
                    "                <div class=\"s-aaa-r\">\n" +
                    "                        <div class=\"name-r\">");
            finalStr.append(name);
            finalStr.append("</div>\n" +
                    "                        <p class=\"aa2\">");

            finalStr.append(str);
            finalStr.append("</p>\n" +
                    "                        <img src=\"http://cn.bing.com/th?id=OIP.nTlF2xVOIBy6N3CzIFji9wHaEo&w=294&h=178&c=7&o=5&dpr=1.5&pid=1.7\" alt=\"\">       \n" +
                    "                </div>\n" +
                    "            </div>");
        }else{
            finalStr.append("<div class=\"box1\">\n" +
                    "                <div class=\"s-aaa-l\">\n" +
                    "                        <img src=\"http://cn.bing.com/th?id=OIP.lh4pmeUF9l-sezuS2F1jiQHaHa&w=227&h=160&c=7&o=5&dpr=1.5&pid=1.7\" alt=\"\">\n" +
                    "                        <div class=\"name-l\">");
            finalStr.append(name);
            finalStr.append("</div>\n" +
                    "                            <p class=\"aa1\">");
            finalStr.append(str);
            finalStr.append("</p>\n" +
                    "                </div>\n" +
                    "            </div>");
        }
        message.append(finalStr);
        this.refrushOrNot = true;
    }

    public void addMessage(String name,String str){
        StringBuilder finalStr = new StringBuilder("");
        if(this.userName.equals(name)){
            finalStr.append("\t\t\t<div class=\"box1\">\n" +
                    "\t\t\t\t<div class=\"aaa-r\">\n" +
                    "\t\t\t\t\t<div class=\"name-r\">");
            finalStr.append(name);
            finalStr.append("</div>\n" +
                    "\t\t\t\t\t<p class=\"aa2\">");
            finalStr.append(str);
            finalStr.append("\n" +
                    "\t\t\t\t\t</p>\n" +
                    "\t\t\t\t\t<img src=\"http://cn.bing.com/th?id=OIP.nTlF2xVOIBy6N3CzIFji9wHaEo&w=294&h=178&c=7&o=5&dpr=1.5&pid=1.7\" alt=\"\">       \n" +
                    "\t\t\t\t</div>\n" +
                    "\t\t\t</div>");
        }else{
            finalStr.append("            <div class=\"box1\">\n" +
                    "                <div class=\"aaa-l\">                    \n" +
                    "\t\t\t\t\t<img src=\"http://cn.bing.com/th?id=OIP.lh4pmeUF9l-sezuS2F1jiQHaHa&w=227&h=160&c=7&o=5&dpr=1.5&pid=1.7\" alt=\"\">\n" +
                    "\t\t\t\t\t<div class=\"name-l\">");
            finalStr.append(name);
            finalStr.append("</div>\n" +
                    "                    <p class=\"aa1\">");
            finalStr.append(str);
            finalStr.append("\n" +
                    "                    </p>\n" +
                    "                </div>\n" +
                    "\t\t\t</div>");
        }
        message.append(finalStr);
        this.refrushOrNot = true;
    }

    public String toString(){
        this.refrushOrNot = false;
        return head+message.toString()+tail;
    }

    public boolean isRefrushOrNot(){
        return refrushOrNot;
    }
}
