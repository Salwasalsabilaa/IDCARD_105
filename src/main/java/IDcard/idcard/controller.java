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
import org.springframework.ui.Model;
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
                          @RequestParam("tanggal")@DateTimeFormat (pattern="yyyy-MM-dd")Date tanggal,
                          @RequestParam("image") MultipartFile file, Model model)
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
            //SimpleDateFormat tgl = new SimpleDateFormat("EEEE, dd MMMM yyyy");
            //String newtanggal = tgl.format(tanggal);
     
            String blob = Base64.encodeBase64String(file.getBytes());
            String gambar = "data:image/jpeg;base64,".concat(blob);
        
        SimpleDateFormat tgl = new SimpleDateFormat("EEEE, dd MMMM yyyy");
        String newTanggal = tgl.format(tanggal);
       
        model.addAttribute("name", text);
        model.addAttribute("tgl", newTanggal);
        model.addAttribute("gambar", gambar);
        
            return "hasil";
    }
}
