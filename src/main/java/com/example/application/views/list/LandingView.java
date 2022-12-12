package com.example.application.views.list;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("list")
@Route(value = "", layout = MainLayout.class)
public class LandingView extends VerticalLayout {

    H1 header = new H1("Welcome!");
    Paragraph p = new Paragraph("This is my first Vaadin project. Well... basically first lol");
    TextField name = new TextField("Name");
    Button button = new Button("Enter!");
    public LandingView() {
        add(header, p);

        button.addClickShortcut(Key.ENTER);

        HorizontalLayout hl = new HorizontalLayout(name, button);
        hl.setDefaultVerticalComponentAlignment(Alignment.BASELINE);
        button.addClickListener(click -> Notification.show("Hej, " + name.getValue()));

        add(hl);

    }

}
