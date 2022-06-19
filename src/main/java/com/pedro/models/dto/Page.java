package com.pedro.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Page {

    private int page;

    private int per_page;

    private long total;

    private long count;
}
