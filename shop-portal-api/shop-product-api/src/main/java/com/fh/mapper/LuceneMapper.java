package com.fh.mapper;

import com.fh.po.ProductBeanPo;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xiezhuang
 * @ClassName LuceneMapper
 * @date 2020/6/30 13:26
 */
@Repository
public class LuceneMapper {

    @Autowired
    private IndexWriter indexWriter;

    @Autowired
    private Analyzer analyzer;

    public void createProductIndex(List<ProductBeanPo> productBeanList) throws IOException {
        List<Document> docs = new ArrayList<Document>();
        productBeanList.forEach(product->{
            Document doc = new Document();
            doc.add(new StringField("id",product.getId()+"", Field.Store.YES));
            doc.add(new TextField("name",product.getName(),Field.Store.YES));
            doc.add(new TextField("subtitle",product.getSubtitle(),Field.Store.YES));
            doc.add(new TextField("detail",product.getDetail(),Field.Store.YES));
            doc.add(new DoubleDocValuesField("price",product.getPrice().doubleValue()));
            doc.add(new LongPoint("stock",product.getStock()));
            doc.add(new LongPoint("status",product.getStatus()));
            docs.add(doc);
        });
        indexWriter.addDocuments(docs);
        indexWriter.commit();
    }
}
