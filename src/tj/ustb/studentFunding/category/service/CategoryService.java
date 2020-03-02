package tj.ustb.studentFunding.category.service;

import java.util.List;

import tj.ustb.studentFunding.category.dao.CategoryDao;
import tj.ustb.studentFunding.category.domain.Category;



public class CategoryService {
	private CategoryDao categoryDao = new CategoryDao();

	/**
	 * 查询所有分类
	 * @return
	 */
	public List<Category> findAll() {
		return categoryDao.findAll();
	} 
}
