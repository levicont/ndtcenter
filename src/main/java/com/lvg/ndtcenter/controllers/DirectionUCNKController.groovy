package com.lvg.ndtcenter.controllers

import com.lvg.ndtcenter.config.R
import com.lvg.ndtcenter.models.Direction
import com.lvg.ndtcenter.services.DirectionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
class DirectionUCNKController {
    @Autowired
    DirectionService directionService


    @RequestMapping(value = 'direction/list', method = RequestMethod.GET)
    String getAll(Map<String, Object> model){
        model.put('content', R.Templates.DIRECTION_LIST_TEMPLATE)
        return 'home'
    }

    @ModelAttribute('directions')
    List<Direction> allDirections(){
        directionService.findAll()
    }


}
