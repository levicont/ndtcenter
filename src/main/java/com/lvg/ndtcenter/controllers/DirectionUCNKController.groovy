package com.lvg.ndtcenter.controllers

import com.lvg.ndtcenter.config.R
import com.lvg.ndtcenter.models.*
import com.lvg.ndtcenter.services.CompanyService
import com.lvg.ndtcenter.services.DirectionService
import groovy.util.logging.Log4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

import javax.validation.Validator

@Controller
@RequestMapping('directions')
@Log4j
@Validated
class DirectionUcnkController {
    @Autowired
    DirectionService directionService
    @Autowired
    CompanyService companyService
    @Autowired
    Validator validator

    @RequestMapping(value = '', method = RequestMethod.GET)
    String getAll(Map<String, Object> model){
        model.put('content', R.Templates.DIRECTION_LIST_TEMPLATE)
        return 'home'
    }

    @RequestMapping(value = '/{directionId}')
    String getDirection(@PathVariable BigInteger directionId, Model model){
        Direction direction = directionService.findByID(directionId)
        if (direction !=null){
            model.addAttribute('content',R.Templates.DIRECTION_TEMPLATE)
            model.addAttribute('direction', direction)
        }
        return 'home'
    }

    @RequestMapping(value = '/{directionId}', params = ['form'], method = RequestMethod.POST)
    String updateDirection(@ModelAttribute Direction direction, BindingResult bindingResult,
                           @RequestParam(value = 'studentLastName', required = true) String studentLastName,
                           @RequestParam(value = 'studentName', required = true) String studentName,
                           @RequestParam(value = 'studentSecondName', required = true) String studentSecondName,
                           @RequestParam(value = 'companyName', required = true) String companyName,
                           Model model){

        if (bindingResult.hasErrors()){
            return "forward:${direction.directionId}?form"
        }
        def updDirection = directionService.findByID(direction.directionId)

        updDirection.bestBeforeDate = direction.bestBeforeDate
        updDirection.learnHours = direction.learnHours
        updDirection.method = direction.method
        updDirection.qualifRate = direction.qualifRate
        updDirection.requestDate = direction.requestDate
        updDirection.requestNumber = direction.requestNumber
        updDirection.sectors = direction.sectors


        updDirection.student.name = studentName
        updDirection.student.lastName = studentLastName
        updDirection.student.secondName = studentSecondName


        updDirection.company = updDirection.company
        updDirection.company.name = companyName




        directionService.save(updDirection)
        return 'redirect:/directions'
    }

    @ModelAttribute('directions')
    List<Direction> allDirections(){
        directionService.findAll()
    }

    @ModelAttribute('ndtMethods')
    List<NDTMethod> ndtMethods(){
        NDTMethod.values()
    }

    @ModelAttribute('qualifRates')
    List<QualifRate> allQualifRates(){
        QualifRate.values()
    }

    @ModelAttribute('sectors')
    List<ISOSectors> allSectors(){
        ISOSectors.values()
    }

    @ModelAttribute('companies')
    List<Company> allCompanies(){
        companyService.findAll()
    }


}
