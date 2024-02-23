package controller;

import dto.SearchRequest;
import dto.SearchResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class SearchFlight {

    @GetMapping
    public SearchResponse search(@RequestBody SearchRequest searchRequest) {
        // Need to do the real search in database
        SearchResponse searchResponse = new SearchResponse();
        return searchResponse;
    }
}
