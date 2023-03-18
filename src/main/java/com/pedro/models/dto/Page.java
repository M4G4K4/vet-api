package com.pedro.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Page {

    private int page;

    private int per_page;

    private long total;

    private long count;
}
