package com.example.Controller;

import com.example.PropUtil.PropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by root on 2/4/17.
 */
@RestController
public class PropertiesController {

    @Autowired
    PropertiesUtil propUtil;

    @RequestMapping(value = "/getproperty/{propertyname}", method = RequestMethod.GET)
    public String getProperty(@PathVariable String propertyname) throws Exception{
        return propUtil.sqlmap.get(propertyname);
    }

}
