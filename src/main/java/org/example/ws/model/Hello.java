//package org.example.ws.model;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//
///**
// * The Greeting class is an entity model object.
// * this class do not have ID or referenceID cause the TransactionalEntity has it
// * Entity annotation is for JPA to recognise it as a table in DB
// *
// * @author Matt Warman
// */
//@Entity
//public class Hello
//{
//
//    @Id     /**  The primary key identifier.  */
//    @GeneratedValue
//    private Long id;
//
//    private String message;
//
//
//    //this empty constructor is for JPA
//    public Hello()
//    {
//
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//
//}
