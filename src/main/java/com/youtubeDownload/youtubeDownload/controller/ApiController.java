package com.youtubeDownload.youtubeDownload.controller;

import com.github.underscore.lodash.U;
import com.youtubeDownload.youtubeDownload.Models.Error;
import com.youtubeDownload.youtubeDownload.Models.Response;
import com.youtubeDownload.youtubeDownload.Models.URL;
import com.youtubeDownload.youtubeDownload.Models.VideoSearchModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.youtubeDownload.youtubeDownload.Service.YoutubeDownload.download;
import static com.youtubeDownload.youtubeDownload.Service.YoutubeDownload.videoSearch;


@RestController
@Api(value = "Youtube DL Api")
public class ApiController {
    private final List<Response> postList = new ArrayList<Response>();

    @RequestMapping(value = "/youtube", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value="Youtube Videosu İndirir",notes = "Lütfen kopyaladığınız video linkini url kısmına belirtin")
    public ResponseEntity youtubePost(@RequestBody URL request) throws IOException, JSONException {
        String response = download(request.getUrl());
        if (response == "false") {
            Error error = new Error();
            error.setStatus("Error");
            error.setCode(500);
            return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<Object>(response, HttpStatus.OK);
        }

    }

    @RequestMapping(value = "/search", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value="Youtubede Video Aramanıza Yardımcı Olur",notes = "Aramak istediğiniz video veya müzik isminizi search parametresine vermeniz yeterli")

    public Response searchVideo(@RequestBody VideoSearchModel request) throws IOException {
        Response response = new Response();
        String res = videoSearch(request.getSearch(), request.getLimit());
        Map<String, Object> jsonObject = U.fromJsonMap(res);
        ArrayList count = (ArrayList) jsonObject.get("value");
        response.setResulSet(jsonObject.get("value"));
        response.setTotalRecord(count.size());
        return response;
    }
}
