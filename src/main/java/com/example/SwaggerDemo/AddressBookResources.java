package com.example.SwaggerDemo;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;


@RestController
@RequestMapping("/api")
public class AddressBookResources {

  ConcurrentHashMap<String,Contact> contacts = new ConcurrentHashMap<String, Contact>();
  Logger logger = LoggerFactory.getLogger(AddressBookResources.class);

  @GetMapping("/{id}")
  @ApiOperation(
    value = "Finds contacts bu id",
    notes = "Provide an id to look up specific contact from address book",
    response = Contact.class
  )
  public Contact getContact(@PathVariable
                            @ApiParam(name = "id", value = "id of the contact you want to retrive",required = true)
                                String id){
      logger.info("Fetching contact for id : "+id);
      return contacts.get(id);
  }

  @GetMapping("/")
  public List<Contact> getAllContacts(){
    return new ArrayList<Contact>(contacts.values());

  }

  @PostMapping("/")
  public Contact addContact(@RequestBody Contact contact){
    contacts.put(contact.getId(),contact);
    return contact;
  }
}
