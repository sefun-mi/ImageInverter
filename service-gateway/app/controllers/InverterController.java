package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import play.mvc.Controller;
import play.mvc.Result;
import com.encentral.ColourFunctional.ImageOp;
import io.swagger.annotations.*;

import java.io.File;

import static play.libs.Json.objectMapper;

public class InverterController extends Controller {

    public Result addImage(String img) throws JsonProcessingException {
        new ImageOp().invertImage(img);
        return ok(objectMapper.writeValueAsString(ImageOp.img);
    }

    public Result getNegative() throws JsonProcessingException{
        File output = new ImageOp().getImage();
        return ok(objectMapper.writeValueAsString(output));
    }
}
