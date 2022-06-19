package com.pedro.utilities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

@NoArgsConstructor
@AllArgsConstructor
public class Filter {

    @DefaultValue("50")
    @QueryParam(value = "per_page")
    String perPage;

    @DefaultValue("1")
    @QueryParam(value = "page")
    String page;

    public Integer getPerPage() {
        return Integer.parseInt(this.perPage);
    }

    public Integer getPage() {
        return Integer.parseInt(this.page);
    }
}
