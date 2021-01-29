package view;

public class NotFound {
    public String toString() {
        String str = new String("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>浩浩聊天室</title>\n" +
                "    <style>\n" +
                "        body{\n" +
                "\t\t\tbackground:url(http://img95.699pic.com/photo/40006/2210.jpg_wh300.jpg) center center;\n" +
                "\t\t\tbackground-size: auto;\n" +
                "\t\t\tbackground-attachment: scroll;\n" +
                "\t\t\tanimation: move 8s linear infinite;\n" +
                "\t\t}\n" +
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
                "\t\t\tanimation: rotate_x 3s linear infinite;\n" +
                "\t\t}\n" +
                "\t\t.rotating2 {\n" +
                "\t\t\tanimation: rotate_y 3s linear infinite;\n" +
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
                "\t\t.box {\n" +
                "\t\t\tposition: fixed;\n" +
                "\t\t\ttop: 50%;\n" +
                "\t\t\tleft: 50%;\n" +
                "\t\t\ttransform: translate(-50%, -50%);\n" +
                "\t\t}\n" +
                "\t\ta {\n" +
                "\t\t\ttext-decoration: none;    \n" +
                "\t\t\tfont-weight: 700;\n" +
                "\t\t\tfont-size: 20px;\n" +
                "\t\t\tcolor: rgba(149, 173, 221, 0.76);\n" +
                "\t\t\tcursor: pointer;\n" +
                "\t\t\ttransition: font-size 3s;\n" +
                "\t\t}\n" +
                "\t\th2, p {\n" +
                "\t\t\tfont-weight: 700;\n" +
                "\t\t\tfont-size: 20px;\n" +
                "\t\t\tcolor: rgba(212, 100, 110, 0.856);\n" +
                "\t\t}\n" +
                "\t\ta:hover {\n" +
                "\t\t\tfont-size: 22px;\n" +
                "\t\t}\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"rotating1\"></div>\n" +
                "    <div class=\"rotating2\"></div>\n" +
                "    <div class=\"box\">\n" +
                "        <h2>404NotFound</h2>\n" +
                "        <p>请重新尝试</p>\n" +
                "        <a href=\"/\">返回</a>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>");
        return str;
    }

}
