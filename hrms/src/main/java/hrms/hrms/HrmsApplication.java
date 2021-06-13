package hrms.hrms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hrms.hrms.core.adapters.MailService;
import hrms.hrms.core.adapters.MailServiceAdapter;
import hrms.hrms.core.adapters.MernisServiceAdapter;
import hrms.hrms.core.adapters.UserCheckService;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.modelmapper.ModelMapper;


@SpringBootApplication
@EnableSwagger2
public class HrmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrmsApplication.class, args);
	}
	
	
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("hrms.hrms"))                                    
          .build();                                           
    }
	
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
//		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
//		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper;
	} 
	
	  @Bean
	    public UserCheckService checkPersonService(){
	        return new MernisServiceAdapter();
	    }
	    
	    @Bean
	    public MailService mailService(){
	        return new MailServiceAdapter();
	    }

}
