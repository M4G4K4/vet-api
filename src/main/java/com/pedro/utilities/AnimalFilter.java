package com.pedro.utilities;

import io.quarkus.panache.common.Parameters;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.ws.rs.QueryParam;

@NoArgsConstructor
@AllArgsConstructor
public class AnimalFilter extends Filter {

    @QueryParam(value = "type")
    String type;

    @QueryParam(value = "sex")
    String sex;


    public String buildQuery() {
        String query = "";

        if (this.type != null) {
            query += "(type=:type)";
        }

        if(!query.equals("")){
           query += " and ";
        }

        if (this.sex != null) {
            query += "(sex=:sex)";
        }

        return query;
    }

    public Parameters buildParameters() {
        Parameters parameters = new Parameters();

        if (this.type != null) {
            parameters.and("type", this.type);
        }

        if (this.sex != null) {
            parameters.and("sex", this.sex);
        }

        return parameters;
    }
}
