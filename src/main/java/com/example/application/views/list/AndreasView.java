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
@Route(value = "/andreasview", layout = MainLayout.class)
public class AndreasView extends VerticalLayout {

    Button buttonClickMe = new Button("Click me!");
    TextField name = new TextField("Name");

    public AndreasView() {

        buttonClickMe.addClickListener(c -> Notification.show("Thanks for clicking, " + name.getValue()));

        HorizontalLayout hlClick = new HorizontalLayout(name, buttonClickMe);
        hlClick.setDefaultVerticalComponentAlignment(Alignment.BASELINE);

        add(new H1("What am I supposed to do?"), hlClick);

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
