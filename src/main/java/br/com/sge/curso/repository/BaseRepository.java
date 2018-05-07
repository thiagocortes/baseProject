package br.com.sge.curso.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.sge.curso.domain.BaseModel;

@NoRepositoryBean
public interface BaseRepository <T extends BaseModel> extends PagingAndSortingRepository<T, Long>{

}
