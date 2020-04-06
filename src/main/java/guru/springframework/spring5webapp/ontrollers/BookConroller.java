/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guru.springframework.spring5webapp.ontrollers;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author koos
 */

@Controller
public class BookConroller
{
    private final BookRepository bookRepository;

    public BookConroller(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }
    
    
            
    @RequestMapping("/books")
    public String getBooks(Model model)
    {
        model.addAttribute("books", bookRepository.findAll());
        
        
        return "books";
    }
    
}
