package com.zhangeaky.mycreate.controller;

import com.zhangeaky.mycreate.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
public class SimpleController {

    @Autowired
    Set<Person> persons;

    @Autowired
    List<Person> personList;

    @Autowired
    Map<String, Person> personMap;

    @Autowired
    Collection<Person> pp;

    @RequestMapping("/set")
    public String set() {
        return persons.getClass().getCanonicalName() + " || " + personList.getClass().getCanonicalName()
                + " || " + personMap.toString() + "_" + personMap.getClass().getCanonicalName()
                + " || " + pp.getClass().getCanonicalName();
    }

}
