package view;

public class Loading {
    public String toString(){
        String str = new String("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>浩浩聊天室</title>\n" +
                "    <style>\n" +
                "        body{\n" +
                "            background:url(http://img95.699pic.com/photo/40006/2210.jpg_wh300.jpg) center center;\n" +
                "            background-size: auto;\n" +
                "            background-attachment: scroll;\n" +
                "            animation: move 8s linear infinite;\n" +
                "        }\n" +
                "\t\t@keyframes move {\n" +
                "\t\t\t0% {\n" +
                "\t\t\t\tbackground-position-y: 0%; \n" +
                "\t\t\t}\n" +
                "\t\t\t100% {\n" +
                "\t\t\t\tbackground-position-y: 100%;\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t\thtml,body {\n" +
                "\t\t\twidth: 100%;\n" +
                "\t\t\theight: 100%;\n" +
                "\t\t}\n" +
                "\t\t.rotating1, .rotating2 {\n" +
                "\t\t\tposition: fixed;\n" +
                "\t\t\ttop: 50%;\n" +
                "\t\t\tleft: 50%;\n" +
                "\t\t\tmargin-left: -250px;\n" +
                "\t\t\tmargin-top: -250px;\n" +
                "\t\t\twidth: 500px;\n" +
                "\t\t\theight: 500px;\n" +
                "\t\t\tborder: 6px solid rgba(81, 96, 133, 0.521);\n" +
                "\t\t\tbox-shadow: 0 0 38px rgba(82, 120, 145, 0.836);\n" +
                "\t\t\tborder-radius: 50%;\n" +
                "\t\t\tanimation: rotate 3s;\n" +
                "\t\t}\n" +
                "\t\t.rotating1 {\n" +
                "\t\t\tanimation: rotate_x 6s infinite;\n" +
                "\t\t}\n" +
                "\t\t.rotating2 {\n" +
                "\t\t\tanimation: rotate_y 6s infinite;\n" +
                "\t\t}\n" +
                "\t\t@keyframes rotate_x {\n" +
                "\t\t\tfrom {\n" +
                "\t\t\t\ttransform: rotateX(0);\n" +
                "\t\t\t}\n" +
                "\t\t\tto {\n" +
                "\t\t\t\ttransform: rotateX(360deg);        \n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t\t@keyframes rotate_y {\n" +
                "\t\t\tfrom {\n" +
                "\t\t\t\ttransform: rotateY(0);\n" +
                "\t\t\t}\n" +
                "\t\t\tto {\n" +
                "\t\t\t\ttransform: rotateY(360deg);        \n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t\tform {\n" +
                "\t\t\tposition: fixed;\n" +
                "\t\t\ttop: 50%;\n" +
                "\t\t\tleft: 50%;\n" +
                "\t\t\ttransform: translate(-50%, -50%);\n" +
                "\t\t}\n" +
                "\t\t.userName {\n" +
                "\t\t\tcolor: rgba(229, 236, 252, 0.911);\n" +
                "\t\t\twidth: 140px;\n" +
                "\t\t\tfont-size: 17px;\n" +
                "\t\t\tbackground-color: rgba(97, 110, 230, 0);\n" +
                "\t\t\tborder-color: rgba(170, 170, 170, 0);\n" +
                "\t\t\tborder-bottom: 3px solid rgba(74, 100, 151, 0.76); \n" +
                "\t\t\ttransition: width 1s, font-size 1s;\n" +
                "\t\t\toutline: none;\n" +
                "\t\t}\n" +
                "\t\t.userName:focus {\n" +
                "\t\t\tfont-variant-ligatures: none;\n" +
                "\t\t\twidth: 200px;\n" +
                "\t\t\tfont-size: 20px;\n" +
                "\t\t\tcolor: rgb(188, 220, 248);\n" +
                "\t\t\tborder-bottom: 3px solid rgba(198, 216, 252, 0.76);\n" +
                "\t\t}\n" +
                "\t\t.put {\n" +
                "\t\t\tfont-weight: 700;\n" +
                "\t\t\tfont-size: 20px;\n" +
                "\t\t\tbackground-color: rgba(170, 170, 170, 0);\n" +
                "\t\t\tcolor: rgba(149, 173, 221, 0.76);\n" +
                "\t\t\tborder-color: rgba(170, 170, 170, 0);\n" +
                "\t\t\tcursor: pointer;\n" +
                "\t\t}\n" +
                "\t\t::-webkit-input-placeholder { /* WebKit, Blink, Edge */\n" +
                "\t\t\tcolor: rgba(183, 208, 247, 0.884);\n" +
                "\t\t}\n" +
                "    </style>\n" +
                "    <script>\n" +
                "        function getValue() {\n" +
                "\t\t\tsessionStorage.setItem(\"user\",document.getElementById(\"userName\").value);\n" +
                "        }\n" +
                "\t\tfunction newUrl() {\n" +
                "\t\t\tvar newUrl=document.getElementById(\"userName\").value;\n" +
                "\t\t\tvar url='/?userName='+ newUrl;\n" +
                "\t\t\tdocument.changeAction.action = url; \n" +
                //"\t\t\t//changeAction.submit(); \n" +
                "\t\t}\n" +
                "    </script> \n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"rotating1\"></div>\n" +
                "    <div class=\"rotating2\"></div>\n" +
                "    <form action=\"\" method=\"POST\" name=\"changeAction\">\n" +
                "        <input type=\"text\" name=\"userName\" id=\"userName\" class=\"userName\" autocomplete=\"off\" placeholder=\"请输入代号\">\n" +
                "        <input type=\"submit\" class=\"put\" value=\"传送\"  onclick=\" getValue(),newUrl()\">\n" +
                "    </form>\n" +
                "</body>\n" +
                "</html>");

        return str;
    }
}
