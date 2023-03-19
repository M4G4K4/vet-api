package com.pedro.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Page {

    private int page;

    private int per_page;

    private long total;

    private long count;

    private long totalPages;
}
