package SevensegPkg;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

/**
 * This class contains templates and methods to create images with digits and dots for sevenseg clocks.
 * 
 * @author Mateusz Szmyjda, Adam Witek
 */
public class Sevenseg {
	
	private Color primaryColor;
	private Color secondaryColor;
	InputStream is =  getClass().getResourceAsStream("7seg.png");
        InputStream isD = getClass().getResourceAsStream("dots.png");
	private BufferedImage basicDigit;
        private BufferedImage basicDots;
	
	private int segAcolor= new Color(255,255,255).getRGB();
	private int segBcolor= new Color(0,0,255).getRGB();
	private int segCcolor= new Color(0,255,0).getRGB();
	private int segDcolor= new Color(0,255,255).getRGB();
	private int segEcolor= new Color(255,0,0).getRGB();
	private int segFcolor= new Color(255,0,255).getRGB();
	private int segGcolor= new Color(255,255,0).getRGB();
	
	
	{
	
	try {
            
	basicDigit = ImageIO.read(is);
        basicDots = ImageIO.read(isD);
	}
	catch(FileNotFoundException e) {
		System.out.println("Brak wzoru wyświetlacza 7segmentowego!");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}   
	
			}
        
        /**
         * Basic constructor.
         */
    public Sevenseg() {
            
    }
	/**
         * This method sets color you want your enabled panels to be.
         * 
         * @param paint Color you want your enabled panels and dots to be.
         */
	public void setPrimaryColor(Color paint)
	{
		this.primaryColor=paint;
	}
	
        /**
         * This method sets color you want your disabled panels to be.
         * 
         * @param paint Color you want your disabled panels and dots to be.
         */
	public void setSecondaryColor(Color paint)
	{
		this.secondaryColor=paint;
	}
	
	
	/**
         * This method returns color of enabled panels.
         * @return Java.AWT.color
         */
	public Color getPrimaryColor()
	{
		return primaryColor;
	}
        
        /**
         * This method returns color of disabled panels.
         * @return Java.AWT.color
         */
	
	public Color getSecondaryColor()
	{
		return secondaryColor; 
	}
	
	/**
         * This method creates images of numbers you handle with a parameter.
         * @param number A number you want to create as image.
         * -1 - creates colons, both enabled and disabled.
         * 0-9 - creates chosen digit
         * 
         * @throws IOException 
         */
	public void createDigit(int number) throws IOException 
	{
            
                BufferedImage temp = ImageIO.read(getClass().getResourceAsStream("7seg.png"));
                BufferedImage tempDOn = ImageIO.read(getClass().getResourceAsStream("dots.png"));
                BufferedImage tempDOff = ImageIO.read(getClass().getResourceAsStream("dots.png"));
                
                File dir = new File("digits");
                boolean isCreated = dir.mkdirs();
                
                switch(number)
                {
                    case -1:
                        for(int i=0;i<32;i++)
                        {
                            for(int j=0;j<144;j++)
                            {
                                if(basicDots.getRGB(i, j)== segBcolor)
                                {
                                    tempDOn.setRGB(i,j, primaryColor.getRGB());
                                    tempDOff.setRGB(i,j, secondaryColor.getRGB());
                                }
                            }
                        }
                        
                        ImageIO.write(tempDOn, "png", new File("digits"+File.separator+"dots1.png"));
                        ImageIO.write(tempDOff, "png", new File("digits"+File.separator+"dots2.png"));
                        
                        break;
                    case 0:
                        for(int i=0; i<94;i++)
                        {
                            for(int j=0;j<144;j++)
                            {
                                if(basicDigit.getRGB(i, j)==segAcolor || basicDigit.getRGB(i, j)==segBcolor || basicDigit.getRGB(i, j)==segCcolor|| basicDigit.getRGB(i, j)==segDcolor || basicDigit.getRGB(i, j)==segEcolor || basicDigit.getRGB(i, j)==segFcolor)
                                {
                                    temp.setRGB(i, j, primaryColor.getRGB());
                                    
                                }
                                
                                else if(basicDigit.getRGB(i, j)==segGcolor)
                                {
                                    temp.setRGB(i, j, secondaryColor.getRGB());
                                }
                            }
                        }
                        try {
                            ImageIO.write(temp, "png", new File("digits"+File.separator+number+".png"));
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        temp=basicDigit;
                        break;
                        
                    case 1:
                        
                        for(int i=0; i<94;i++)
                        {
                            for(int j=0;j<144;j++)
                            {
                                if( basicDigit.getRGB(i, j)==segBcolor || basicDigit.getRGB(i, j)==segCcolor )
                                {
                                    temp.setRGB(i, j, primaryColor.getRGB());
                                    
                                }
                                
                                else if(basicDigit.getRGB(i, j)==segAcolor|| basicDigit.getRGB(i, j)==segGcolor || basicDigit.getRGB(i, j)==segDcolor|| basicDigit.getRGB(i, j)==segEcolor || basicDigit.getRGB(i, j)==segFcolor)
                                {
                                    temp.setRGB(i, j, secondaryColor.getRGB());
                                }
                            }
                        }
                        try {
                            ImageIO.write(temp, "png", new File("digits"+File.separator+number+".png"));
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        temp=basicDigit;
                        break;
                        
                    case 2:
                        
                        for(int i=0; i<94;i++)
                        {
                            for(int j=0;j<144;j++)
                            {
                                if(basicDigit.getRGB(i, j)==segAcolor || basicDigit.getRGB(i, j)==segBcolor || basicDigit.getRGB(i, j)==segDcolor || basicDigit.getRGB(i, j)==segEcolor|| basicDigit.getRGB(i, j)==segGcolor )
                                {
                                    temp.setRGB(i, j, primaryColor.getRGB());
                                    
                                }
                                
                                else if(basicDigit.getRGB(i, j)==segCcolor || basicDigit.getRGB(i, j)==segFcolor)
                                {
                                    temp.setRGB(i, j, secondaryColor.getRGB());
                                }
                            }
                        }
                        try {
                            ImageIO.write(temp, "png", new File("digits"+File.separator+number+".png"));
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        break;
                        
                    case 3:
                        
                        for(int i=0; i<94;i++)
                        {
                            for(int j=0;j<144;j++)
                            {
                                if(basicDigit.getRGB(i, j)==segAcolor || basicDigit.getRGB(i, j)==segBcolor || basicDigit.getRGB(i, j)==segDcolor || basicDigit.getRGB(i, j)==segCcolor|| basicDigit.getRGB(i, j)==segGcolor )
                                {
                                    temp.setRGB(i, j, primaryColor.getRGB());
                                    
                                }
                                
                                else if(basicDigit.getRGB(i, j)==segEcolor || basicDigit.getRGB(i, j)==segFcolor)
                                {
                                    temp.setRGB(i, j, secondaryColor.getRGB());
                                }
                            }
                        }
                        try {
                            ImageIO.write(temp, "png", new File("digits"+File.separator+number+".png"));
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        break;
                        
                    case 4:
                        
                        for(int i=0; i<94;i++)
                        {
                            for(int j=0;j<144;j++)
                            {
                                if(basicDigit.getRGB(i, j)==segBcolor || basicDigit.getRGB(i, j)==segCcolor || basicDigit.getRGB(i, j)==segFcolor|| basicDigit.getRGB(i, j)==segGcolor )
                                {
                                    temp.setRGB(i, j, primaryColor.getRGB());
                                    
                                }
                                
                                else if(basicDigit.getRGB(i, j)==segAcolor || basicDigit.getRGB(i, j)==segEcolor || basicDigit.getRGB(i, j)==segDcolor)
                                {
                                    temp.setRGB(i, j, secondaryColor.getRGB());
                                }
                            }
                        }
                        try {
                            ImageIO.write(temp, "png", new File("digits"+File.separator+number+".png"));
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        break;
                        
                    case 5:
                        
                        for(int i=0; i<94;i++)
                        {
                            for(int j=0;j<144;j++)
                            {
                                if(basicDigit.getRGB(i, j)==segAcolor || basicDigit.getRGB(i, j)==segFcolor || basicDigit.getRGB(i, j)==segDcolor || basicDigit.getRGB(i, j)==segCcolor|| basicDigit.getRGB(i, j)==segGcolor )
                                {
                                    temp.setRGB(i, j, primaryColor.getRGB());
                                    
                                }
                                
                                else if(basicDigit.getRGB(i, j)==segBcolor || basicDigit.getRGB(i, j)==segEcolor)
                                {
                                    temp.setRGB(i, j, secondaryColor.getRGB());
                                }
                            }
                        }
                        try {
                            ImageIO.write(temp, "png", new File("digits"+File.separator+number+".png"));
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        break;
                        
                    case 6:
                        
                        for(int i=0; i<94;i++)
                        {
                            for(int j=0;j<144;j++)
                            {
                                if(basicDigit.getRGB(i, j)==segAcolor || basicDigit.getRGB(i, j)==segFcolor || basicDigit.getRGB(i, j)==segDcolor || basicDigit.getRGB(i, j)==segEcolor || basicDigit.getRGB(i, j)==segCcolor|| basicDigit.getRGB(i, j)==segGcolor )
                                {
                                    temp.setRGB(i, j, primaryColor.getRGB());
                                    
                                }
                                
                                else if(basicDigit.getRGB(i, j)==segBcolor )
                                {
                                    temp.setRGB(i, j, secondaryColor.getRGB());
                                }
                            }
                        }
                        try {
                            ImageIO.write(temp, "png", new File("digits"+File.separator+number+".png"));
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        break;
                        
                    case 7:
                        
                        for(int i=0; i<94;i++)
                        {
                            for(int j=0;j<144;j++)
                            {
                                if(basicDigit.getRGB(i, j)==segAcolor||  basicDigit.getRGB(i, j)==segBcolor || basicDigit.getRGB(i, j)==segCcolor )
                                {
                                    temp.setRGB(i, j, primaryColor.getRGB());
                                    
                                }
                                
                                else if(basicDigit.getRGB(i, j)==segGcolor || basicDigit.getRGB(i, j)==segDcolor|| basicDigit.getRGB(i, j)==segEcolor || basicDigit.getRGB(i, j)==segFcolor)
                                {
                                    temp.setRGB(i, j, secondaryColor.getRGB());
                                }
                            }
                        }
                        try {
                            ImageIO.write(temp, "png", new File("digits"+File.separator+number+".png"));
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        temp=basicDigit;
                        break;
                        
                    case 8:
                        
                        for(int i=0; i<94;i++)
                        {
                            for(int j=0;j<144;j++)
                            {
                                if(basicDigit.getRGB(i, j)==segAcolor || basicDigit.getRGB(i, j)==segBcolor || basicDigit.getRGB(i, j)==segFcolor || basicDigit.getRGB(i, j)==segDcolor || basicDigit.getRGB(i, j)==segEcolor || basicDigit.getRGB(i, j)==segCcolor|| basicDigit.getRGB(i, j)==segGcolor )
                                {
                                    temp.setRGB(i, j, primaryColor.getRGB());
                                    
                                }
                                
                            }
                        }
                        try {
                            ImageIO.write(temp, "png", new File("digits"+File.separator+number+".png"));
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        break;
                        
                    case 9:
                        
                        for(int i=0; i<94;i++)
                        {
                            for(int j=0;j<144;j++)
                            {
                                if(basicDigit.getRGB(i, j)==segAcolor || basicDigit.getRGB(i, j)==segBcolor || basicDigit.getRGB(i, j)==segFcolor || basicDigit.getRGB(i, j)==segDcolor || basicDigit.getRGB(i, j)==segCcolor|| basicDigit.getRGB(i, j)==segGcolor )
                                {
                                    temp.setRGB(i, j, primaryColor.getRGB());
                                    
                                }
                                else if(basicDigit.getRGB(i, j)==segEcolor)
                                {
                                    temp.setRGB(i,j,secondaryColor.getRGB());
                                }
                                
                            }
                        }
                        try {
                            ImageIO.write(temp, "png", new File("digits"+File.separator+number+".png"));
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        break;
                }
            } 
	}


