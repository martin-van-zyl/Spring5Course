/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guru.springframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import guru.springframework.spring5webapp.domain.Book;

/**
 *
 * @author koos
 */
public interface BookRepository extends CrudRepository<Book, Long>
{
    
}
