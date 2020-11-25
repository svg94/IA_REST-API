package org.hbrs.ia.contract.rest;

import org.hbrs.ia.contract.ManagePersonal;
import org.hbrs.ia.model.SalesMan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Salesmen")
public class SalesManController {

    private ManagePersonal m = RestApplication.manager;     //We can only have one Manager. If we declare many (e.g. in another Controller)
                                                            //Then we would get an error because each time the manager gets initialised, a db on fixed port will be created (or opened)
    @GetMapping                                             //If it's already open, that would cause an Exception
    public String startScreen(){
        return "Category Salesman";
    }
    @GetMapping("/{id}")
    public SalesMan getByID(@PathVariable() int id){
        return m.readSalesMan(id);
    }
    @GetMapping("/query")                                                //We need a key-value pair. I´m not sure how to get the name of the query parameter so
    public List<SalesMan> query(@RequestParam(value = "key") String key,@RequestParam(value = "value") String value){    //The solution is to have a query parameter that is a String with value and key splitted by a "_"
        return m.querySalesMan(value,key);
    }
    @PostMapping
    public void CreateSalesMan(@RequestBody() SalesMan s){
        m.createSalesMan(s);
    }
}
