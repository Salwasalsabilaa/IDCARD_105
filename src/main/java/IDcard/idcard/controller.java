/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IDcard.idcard;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Inspiron
 */
@Controller
public class controller {
    
    @ResponseBody
    @RequestMapping ("/getData")
    public String getData(@RequestParam("nama") String text,
                          @RequestParam("image") MultipartFile file,
                          @RequestParam("tanggal")@DateTimeFormat (pattern="yyyy-MM-dd")Date tanggal)
                          throws IOException{
        
//            String buffer = text.toLowerCase();
//            if (buffer.equals("Beomgyu")){
//                
//                text = text + "Ganteng";
//            }
//            else {
//                text = text + "Keren";
//            }
            //Date date = new Date();
            SimpleDateFormat tgl = new SimpleDateFormat("EEEE, dd MMMM yyyy");
            String newtanggal = tgl.format(tanggal);
     
            String blob = Base64.encodeBase64String(file.getBytes());
                    
            return "<h1>"+text+"</h1>"+"<hr>"+newtanggal+"<br><img width=400 src='data:image/jpeg;base64,"+blob+"'/><br>";
    }
}
