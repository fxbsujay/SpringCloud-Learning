package com.susu.controller;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.aggregations.Aggregation;
import co.elastic.clients.elasticsearch._types.query_dsl.BoolQuery;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.indices.CreateIndexResponse;
import co.elastic.clients.elasticsearch.indices.DeleteIndexResponse;
import co.elastic.clients.elasticsearch.indices.GetIndexResponse;
import co.elastic.clients.json.JsonpMapper;
import com.susu.dto.CellPhoneDTO;
import com.susu.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.core.*;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.data.elasticsearch.core.query.StringQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("es")
@Slf4j
public class EsController {

    @Autowired
    private ElasticsearchOperations operations;

    @Autowired
    private ElasticsearchClient elasticsearchClient;

    @Autowired
    private RestClient restClient;

    @Autowired
    private JsonpMapper mapper;

    /**
     * 索引
     */
    @GetMapping("index")
    public ResponseEntity<String> index() throws IOException {
        String index = "shopping";
        IndexOperations indexOperations = operations.indexOps(IndexCoordinates.of(index));
        indexOperations.create();

        List<IndexInformation> information = indexOperations.getInformation();
        for (IndexInformation indexInformation : information) {
            log.info("index info name: {}", indexInformation.getName());
            log.info("index info settings: {}", indexInformation.getSettings());
        }

        indexOperations.delete();

        IndexOperations userIndex = operations.indexOps(UserDTO.class);
        userIndex.create();

        return ResponseEntity.ok(index);
    }

    /**
     * 文档
     */
    @GetMapping("doc")
    public ResponseEntity<String> doc() throws IOException {
        CellPhoneDTO phone = new CellPhoneDTO();
        phone.setId("1");
        phone.setName("小米手机");
        phone.setPrice(2999.00f);
        phone.setCreatedDate(new Date());
        CellPhoneDTO save = operations.save(phone);

        log.info("phone info : {}", save);

        CellPhoneDTO info = operations.get(save.getId(), CellPhoneDTO.class);
        log.info("get phone info : {}", info);

        String delete = operations.delete(phone);

        List<CellPhoneDTO> list = new ArrayList<>();
        list.add(phone);

        CellPhoneDTO twoPhone = new CellPhoneDTO();
        twoPhone.setId("2");
        twoPhone.setName("华为手机");
        twoPhone.setPrice(6999.00f);
        twoPhone.setCreatedDate(new Date());
        list.add(twoPhone);

        operations.save(list);
        return ResponseEntity.ok(delete);
    }

    /**
     * 文档
     */
    @GetMapping("search")
    public ResponseEntity<List<CellPhoneDTO>> search() throws IOException {
        List<CellPhoneDTO> list = new ArrayList<>();

        // 标准查询
        Criteria criteria = new Criteria("name").is("小米手机");
        Query query = new CriteriaQuery(criteria);
        SearchHits<CellPhoneDTO> search = operations.search(query, CellPhoneDTO.class);
        List<SearchHit<CellPhoneDTO>> searchHits = search.getSearchHits();
        for (SearchHit<CellPhoneDTO> searchHit : searchHits) {
            list.add(searchHit.getContent());
        }

        // 字符串查询
        Query stringQuery = new StringQuery("{ \"match_phrase\": { \"name\": { \"query\": \"小米手机\" } } } ");
        SearchHits<CellPhoneDTO> stringSearchHits = operations.search(stringQuery, CellPhoneDTO.class);


        // 原生查询
        Query nativeQuery = NativeQuery.builder()
                .withQuery(q -> q.matchPhrase(m -> m.field("name").query("小米手机")))
                .build();
        SearchHits<CellPhoneDTO> nativeSearchHits = operations.search(nativeQuery, CellPhoneDTO.class);
        return ResponseEntity.ok(list);
    }

}
