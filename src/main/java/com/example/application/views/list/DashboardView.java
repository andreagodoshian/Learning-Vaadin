package com.example.application.views.list;

import com.example.application.data.service.CrmService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.ChartType;
import com.vaadin.flow.component.charts.model.DataSeries;
import com.vaadin.flow.component.charts.model.DataSeriesItem;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.annotation.security.PermitAll;

@Route(value = "/dashboard", layout = MainLayout.class)
@PageTitle("Dashboard | Vaadin Tutorial")
@PermitAll // all that are logged in
public class DashboardView extends VerticalLayout {
    private CrmService service;

    public DashboardView(CrmService service) {
        this.service = service;
        addClassName("dashboard-view");
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        H2 disclaimer = new H2("Please be advised: the chart may not be visible, since I haven't paid for Vaadin");

        add(getContactStats(), disclaimer, getCompaniesChart());
    }
    private Component getContactStats() {
        Span stats = new Span(service.countContacts() + " contact(s)");
        stats.addClassNames("text-xl", "mt-m");
        return stats;
    }
    private Component getCompaniesChart() {
        Chart chart = new Chart(ChartType.PIE);
        DataSeries dataSeries = new DataSeries();
        service.findAllCompanies().forEach(x -> dataSeries.add(
                new DataSeriesItem(x.getName(), x.getEmployeeCount())));

        return chart;
    }
}