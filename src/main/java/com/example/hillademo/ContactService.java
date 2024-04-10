package com.example.hillademo;

import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;
import com.vaadin.hilla.crud.CrudRepositoryService;
import org.hibernate.internal.build.AllowNonPortable;

import java.util.List;

@BrowserCallable
@AnonymousAllowed
public class ContactService extends CrudRepositoryService<Contact, Long, ContactRepository>{


}
