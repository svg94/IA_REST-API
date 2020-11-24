package org.hbrs.ia.contract.rest;

import org.hbrs.ia.model.SalesMan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Salesman")
public class SalesManController {

    private List<SalesMan> salesmen = new ArrayList<>();

    @GetMapping
    public List<SalesMan> getAll(){
        return salesmen;
    }
}
