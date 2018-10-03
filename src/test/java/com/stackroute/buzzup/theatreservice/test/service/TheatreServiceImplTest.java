package com.stackroute.buzzup.theatreservice.test.service;


import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.stackroute.buzzup.theatreservice.exception.TheatreNotFoundException;
import com.stackroute.buzzup.theatreservice.model.Theatre;
import com.stackroute.buzzup.theatreservice.repository.TheatreRepository;
import com.stackroute.buzzup.theatreservice.service.TheatreServiceImpl;

//import com.stackroute.keepnote.model.Category;
public class TheatreServiceImplTest {

	private Theatre theatre;

	@Mock
	private  TheatreRepository thetarerepository;

	@InjectMocks
	private TheatreServiceImpl theatreserviceimpl;
	private List<Theatre> allTheatre;
	Optional<Theatre> options;

	@Before
	public void Setup() throws Exception
	{
		MockitoAnnotations.initMocks(this);

		 theatre=new Theatre();
		theatre.setTheatreId("1");
		theatre.setEmailId("utkarsh@gmail.com");
		theatre.setCity("pune");
		theatre.setLicenseNo("qw12");
		theatre.setName("pvr");
		allTheatre=new ArrayList<>();
		allTheatre.add(theatre);
		options=Optional.of(theatre);
	}

	/*@Test
	public void createTheatreSuccess() throws Exception{
		when(thetarerepository.insert((Theatre) any())).thenReturn (theatre);
		Theatre savedTheatre=theatreserviceimpl.saveTheatre(theatre);
		Assert.assertEquals(theatre,savedTheatre);
	}
	*/
	/*
	 * @Test
	public void saveMovieScreeningTestSuccess() throws Exception {
		when(moviescreeningrepository.insert((MovieScreening) any())).thenReturn(moviescreening);
		MovieScreening savedmovie = moviescreeningserviceimpl.saveMovieDetails(moviescreening);
		Assert.assertEquals(moviescreening, savedmovie);
	}
	 */
	
	/*@Test(expected=TheatreAlreadyExistsException.class)
	public void saveTheatreSuccess() throws TheatreAlreadyExistsException
	{
		when(thetarerepository.save((Theatre) any())).thenReturn(theatre);
		Theatre  savetheatre =theatreserviceimpl.saveTheatre(theatre);
		Assert.assertEquals(theatre,savetheatre);
	}*/
	
	
	@Test
	public void getByEmailSuccess() throws Exception
	{
		when(thetarerepository.getByEmailId(theatre.getEmailId())).thenReturn(theatre);
		Theatre savedTheatre =theatreserviceimpl.getEmailId(theatre.getEmailId());
		Assert.assertEquals(theatre,savedTheatre);
	}
	@Test
	public void getByEmailFailure()throws Exception
	{
		when(thetarerepository.getByEmailId(theatre.getEmailId())).thenReturn(theatre);
		theatre.setEmailId("u");
	}

	@Test
	public void getTheatreByTheatreTitleSuccess() throws TheatreNotFoundException
	{
		when(thetarerepository.getByName(theatre.getName())).thenReturn(theatre);
		Theatre saveTheatre =theatreserviceimpl.getTheatreByTheatreTitle(theatre.getName());
		Assert.assertEquals(theatre,saveTheatre);
	}
	
	@Test
	public void getTheatreByTheatreTitleFailure() throws TheatreNotFoundException
	{
		when(thetarerepository.getByName(theatre.getName())).thenReturn(theatre);
		theatre.setName("abcd");
	}
}