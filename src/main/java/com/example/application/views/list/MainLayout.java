package com.example.application.views.list;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;

public class MainLayout extends AppLayout {

    public MainLayout() {
        createHeader();
        createDrawer();
    }
    private void createHeader() {
        H1 logo = new H1("Vaadin CRM Tutorial");
        logo.addClassNames("text-l", "m-m"); // see Vaadin docs, like bootstrap

        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo);
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.expand(logo);
        header.setWidthFull();
        header.addClassNames("py-0", "px-m");

        addToNavbar(header);
    }
    private void createDrawer() {
        RouterLink landingView = new RouterLink("Landing", LandingView.class);
        RouterLink listView = new RouterLink("List", ListView.class);
        RouterLink dashboardView = new RouterLink("Dashboard", DashboardView.class);
        RouterLink andreasView = new RouterLink("Andrea's View", AndreasView.class);

        listView.setHighlightCondition(HighlightConditions.sameLocation());

        addToDrawer(new VerticalLayout(
                landingView, listView, dashboardView, andreasView
        ));
    }
}
