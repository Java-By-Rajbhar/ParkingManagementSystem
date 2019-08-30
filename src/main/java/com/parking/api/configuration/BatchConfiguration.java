package com.parking.api.configuration;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
/*
	@Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public DataSource dataSource;
    
    @Bean
	public JdbcCursorItemReader<Product> reader(){
		JdbcCursorItemReader<Product> cursorItemReader = new JdbcCursorItemReader<>();
		cursorItemReader.setDataSource(dataSource);
		cursorItemReader.setSql("SELECT id, category, name, brand, model, price FROM product");
		cursorItemReader.setRowMapper(new ProductRowMapper());
		return cursorItemReader;
	}
	
	@Bean
	public ProductItemProcessor processor() {
		return new ProductItemProcessor();
	}
	
	@Bean
	public FlatFileItemWriter<Product> writer(){
		
		FlatFileItemWriter<Product> writer = new FlatFileItemWriter<>();
		writer.setResource(new ClassPathResource("product.csv"));
		
		DelimitedLineAggregator<Product> lineAggregator = new DelimitedLineAggregator<>();
		lineAggregator.setDelimiter(",");
		
		BeanWrapperFieldExtractor<Product> fieldExtractor = new BeanWrapperFieldExtractor<>();
		fieldExtractor.setNames(new String[] {"id", "category", "name", "brand", "model", "price"});
		
		lineAggregator.setFieldExtractor(fieldExtractor);
		
		writer.setLineAggregator(lineAggregator);
		
		return writer;
	}
	
	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1")
				.<Product, Product>chunk(10)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.build();
	}
	
	@Bean
	public Job exportProductJob() {
		return jobBuilderFactory.get("exportJob")
				.incrementer(new RunIdIncrementer())
				.flow(step1())
				.end()
				.build();
	}*/
}
