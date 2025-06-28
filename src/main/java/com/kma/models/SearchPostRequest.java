package com.kma.models;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class SearchPostRequest {
    String title;
    String content;
    String authorName;

}
