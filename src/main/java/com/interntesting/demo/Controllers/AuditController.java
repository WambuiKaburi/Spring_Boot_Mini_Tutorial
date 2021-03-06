package com.interntesting.demo.Controllers;

import com.interntesting.demo.Models.User;
import org.javers.core.Javers;
import org.javers.core.diff.Change;
import org.javers.repository.jql.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/audit")
public class AuditController {

    private final Javers javers;

    @Autowired
    public AuditController(Javers javers) {
        this.javers = javers;
    }

    @RequestMapping("/users")
    public String getPersonChanges() {
        QueryBuilder jqlQuery = QueryBuilder.byClass(User.class);

        List<Change> changes = javers.findChanges(jqlQuery.build());

        return javers.getJsonConverter().toJson(changes);
    }
}

