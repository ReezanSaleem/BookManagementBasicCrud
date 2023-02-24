package org.userwebapp.service;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.userwebapp.model.Book;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BooksDAOI implements BooksDAO {
    private JdbcTemplate jdbcTemplate;

    public BooksDAOI() {
        DataSource ds = getDataSource();
        jdbcTemplate = new JdbcTemplate(ds);
    }

    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/cruddb");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return dataSource;
    }

    @Override
    public int save(Book book) {
        String query = "insert into books(ISBN, name, author, publisher) values(?,?,?,?);";
        return jdbcTemplate.update(query, book.getISBN(), book.getName(), book.getAuthor(), book.getPublisher());
    }

    @Override
    public int update(Book book) {
        String sqlQuery = "Update books set ISBN=?, name=?, author=?, publisher=? where ISBN=?;";
        return jdbcTemplate.update(sqlQuery, book.getISBN(), book.getName(), book.getAuthor(), book.getPublisher(), book.getISBN());
    }

    @Override
    public void delete(int id) {
        String sql = "Delete from books where ISBN=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Book getBook(int isbn) {
        String sql = "select * from books where ISBN=" + isbn;

        ResultSetExtractor<Book> extractor = new ResultSetExtractor() {
            @Override
            public Book extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    int isbn = rs.getInt("ISBN");
                    String name = rs.getString("name"), publisher = rs.getString("publisher"), author = rs.getString("author");

                    return new Book(isbn, name, author, publisher);

                } else return null;
            }
        };
        return jdbcTemplate.query(sql, extractor);
    }


    @Override
    public List<Book> getBookList() {
        String sqlQuery = "select * from books";
        List<Book> bookList = new ArrayList<>();

        ResultSetExtractor<List> extractor = new ResultSetExtractor() {
            @Override
            public List<Book> extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    do {
                        bookList.add(new Book(rs.getInt("ISBN"), rs.getString("name"), rs.getString("author"), rs.getString("publisher")));
                    } while (rs.next());
                }
                return bookList;
            }
        };

        return jdbcTemplate.query(sqlQuery, extractor);

//        RowMapper <Book> rowMapper = new RowMapper<Book>(){
        //@override
        //public Book mapRow(Resultset rs, int rowNum) throws SQLException{
        //int id = rs.getInt();
        //Stirng......
        //return new Book(isbn,....);
        //}
        //};
        //jdbcTemplate.query(sql, rowMapper);
    }
}
