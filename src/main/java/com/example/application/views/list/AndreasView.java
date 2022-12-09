package com.example.application.views.list;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Andrea's View")
@Route("/andreasview")
public class AndreasView extends VerticalLayout {

    Button buttonClickMe = new Button("Click me!");
    Button buttonSubmit = new Button("Submit!");
    Button buttonSleep = new Button("Sleep!");

    TextField textClickMe = new TextField("Click me!");
    TextField textSubmit = new TextField("Submit!");
    TextField textSleep = new TextField("Sleep!");

    public AndreasView() {

        buttonClickMe.addClickListener(c -> Notification.show("Time to click, " + textClickMe.getValue()));

        buttonSubmit.addClickListener(c -> Notification.show("Time to submit, " + textSubmit.getValue()));

        buttonSleep.addClickListener(c -> Notification.show("Time to sleep, " + textSleep.getValue()));

        HorizontalLayout hlClick = new HorizontalLayout(textClickMe, buttonClickMe);
        HorizontalLayout hlSubmit = new HorizontalLayout(textSubmit, buttonSubmit);
        HorizontalLayout hlSleep = new HorizontalLayout(textSleep, buttonSleep);
        hlClick.setDefaultVerticalComponentAlignment(Alignment.BASELINE);
        hlSubmit.setDefaultVerticalComponentAlignment(Alignment.AUTO);
        hlSleep.setDefaultVerticalComponentAlignment(Alignment.START);

        add(new H1("What am I supposed to do?"), hlClick, hlSubmit, hlSleep);

        DatePicker datePicker = new DatePicker("Start date");
        add(datePicker);

        EmailField validEmailField = new EmailField();
        validEmailField.setLabel("Email address");
        validEmailField.getElement().setAttribute("name", "email");
        validEmailField.setValue("julia.scheider@email.com");
        validEmailField.setErrorMessage("Enter a valid email address");
        validEmailField.setClearButtonVisible(true);

        add(validEmailField);

        TextArea textArea = new TextArea();
        textArea.setWidthFull();
        textArea.setLabel("Description");
        textArea.setValue("loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum");
        add(textArea);


    }
}
