package com.qf.forum.proj.controller;
/*
 *   Author = Liewona
 *   Date = 2020/11/3 10:43
 */

import com.qf.forum.proj.result.Result;
import com.qf.forum.proj.result.WangEditorResult;
import com.qf.forum.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.UUID;


@RequestMapping("up")
@RestController
public class UploadController {

    private Logger log = LoggerFactory.getLogger(UploadController.class);

    /**
     *
     * @param upfile
     * @return
     */
    @PostMapping("dis")
    public Result discussImgUpload(MultipartFile upfile) {
        File file = new File(StringUtils.UP_PATH);

        if(! file.exists()) {
            file.mkdirs();
        }

        String filename = upfile.getOriginalFilename();
        filename = UUID.randomUUID().toString().replace("-","").concat(filename);

        try {
            upfile.transferTo(new File(StringUtils.UP_PATH, filename));
        } catch (IOException e) {
            e.printStackTrace();
            return new WangEditorResult(9999);
        }

        return new WangEditorResult(0, new String[] { StringUtils.IMG_SERVER + filename });
    }

}
