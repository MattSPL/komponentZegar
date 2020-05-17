/*
 * @Politechnika Koszalińska 2020
    Mateusz Szmyjda, Adam Witek
 */
package clockPkg;

import SevensegPkg.Sevenseg;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.sound.sampled.*;


/**
 * This class is a graphical sevenseg clock extending JPanel. It can be a clock, a timer or a stopwatch, also you can change
 * colors of panels and displayed time format.
 * 
 * @author Mateusz Szmyjda, Adam Witek
 */
public class Clock extends JPanel{
    
    Sevenseg alfa = new Sevenseg();
    LocalTime now;
    private int hour0;
    private int hour1;
    private int min0;
    private int min1;
    private int sec0;
    private int sec1;
    private int mil2;
    private int mil1;
    private int mil0;
    private JLabel digM0;
    private JLabel digM1;
    private JLabel digM2;
    private JLabel dig1;
    private JLabel dig2;
    private JLabel dig3;
    private JLabel dig4;
    private JLabel dig5;
    private JLabel dig6;
    private JLabel dots;
    private JLabel dots2;
    private JLabel dots3;
     
    private JPanel panel = this;
    private ImageIcon[] dotsAr = new ImageIcon[2];
    //ImageIcon[] dotsAr2 = new ImageIcon[2];
    private ArrayList numbers = new ArrayList(10);
    
    private int digitWidth=94;
    private int digitHeight=144;
    private int dotWidth=32;
    
    private boolean colorChanged= true;
    private boolean resized = false;
    
    private Image image;
    
    private boolean clockPerm;
    private boolean timerPerm;
    private boolean stopWatchPerm;
    private boolean stopwatchRunning;
    private boolean stopwatchStopped;
    
    private Thread t;
    
    
    private long start=0;
    
    /**
     * Basic constructor.
     */
    public Clock(){
    
        
    }
    
    /**
     * Creates digit images and adds handlers to whole panel. It's necessary to use it at least once before running clock.
     */
    public void create()
    {
        if(alfa.getPrimaryColor()==null)
            {
               alfa.setPrimaryColor(Color.green);
            }
            
            if(alfa.getSecondaryColor()==null)
            {
                alfa.setSecondaryColor(Color.green.darker().darker().darker());
            }
            
                    for(int i=-1;i<=9;i++)
                    {
            try {
                alfa.createDigit(i); 
                
            } catch (IOException ex) {
                Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
            }
                    }
                    
			dig1 = new JLabel();
                        dig2 = new JLabel();
                        dig3 = new JLabel();
                        dig4 = new JLabel();
                        dig5 = new JLabel();
                        dig6 = new JLabel();
                        dots = new JLabel();
                        dots2 = new JLabel();
                        dots3 = new JLabel();
                        digM2 = new JLabel();
                        digM1 = new JLabel();
                        digM0 = new JLabel();
			
                        FlowLayout layout = new FlowLayout();
                        
                        panel.setLayout(layout);
                        panel.setBackground(Color.DARK_GRAY.darker());
                        panel.add(dig6);
                        panel.add(dig5);
                        panel.add(dots2);
                        panel.add(dig4);
                        panel.add(dig3);
                        panel.add(dots);
                        panel.add(dig2);
                        panel.add(dig1);
                       
    }
    
    /**
     * This method displays running clock and turns off timer and stopwatch.
     */
    
    public void runClock()
    { 
        colorChanged = true;
        clockPerm=true;
        timerPerm=false;
        stopWatchPerm=false;
        
       t = new Thread( new Runnable(){
      @Override
      public void run(){
         
     
        while(clockPerm)
			{ 
                            updateSigns();
                            now = LocalTime.now();
                            assignSigns(now);
                            displaySigns();
                        
            try {
                Thread.sleep(16);
            } catch (InterruptedException ex) {
                Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
            }
			}
                        
		 }
   });
   t.start();	
		
    } 
    
    /**
     * This method displays running timer set with parameters. 
     * @param hrs Hours to count
     * @param mins Minutes to count
     * @param secs Seconds to count
     * 
     * 
     */
    
    public void runTimer(int hrs, int mins, int secs) {
    
        try {
            
            clockPerm=false;
            timerPerm=true;
            stopWatchPerm=false;
            
            InputStream src = getClass().getResourceAsStream("beep.wav");
            InputStream audioSrc = new BufferedInputStream(src);
            AudioInputStream beep = AudioSystem.getAudioInputStream(audioSrc);
            Clip clip = AudioSystem.getClip();
            clip.open(beep);

LocalTime nowTimer = LocalTime.now();
LocalTime endTimer = nowTimer.plusHours(hrs).plusMinutes(mins).plusSeconds(secs);

colorChanged=true;

t = new Thread( new Runnable(){
    @Override
    public void run(){
        
        while(timerPerm)
        {
            updateSigns();
            
            LocalTime timerDuration = endTimer.minusHours(LocalTime.now().getHour()).minusMinutes(LocalTime.now().getMinute()).minusSeconds(LocalTime.now().getSecond()).minusNanos(LocalTime.now().getNano());
            assignSigns(timerDuration);
            displaySigns();
            
            
            if(sec0==0 && sec1==0 && min0==0 && min1==0 && hour0==0 && hour1==0 && mil2==0 && mil1<=1)
            {
                //Toolkit.getDefaultToolkit().beep();
                clip.start();
                JOptionPane.showMessageDialog(panel,
                        "Czas dobiegł końca", "", JOptionPane.INFORMATION_MESSAGE);
                runClock();
                //break;
            }
            try {
                Thread.sleep(16);
            } catch (InterruptedException ex) {
                Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
});
t.start();
        } catch (LineUnavailableException | IOException ex) {
            Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * This method prepares stopwatch to run and sets zeros on display. It's necessary to run stopwatch properly.
     */
    
    public void stopwatchOpen()
    {
        timerPerm=false;
        clockPerm=false;
        stopWatchPerm=true;
        LocalTime displayedTime = LocalTime.MIDNIGHT;
        //assignSigns(displayedTime);
        colorChanged=true;
        stopwatchStopped = false;
        
        //LocalTime countedTime;
        
        t = new Thread( new Runnable(){
      @Override
      public void run(){
         
        LocalTime countedTime = LocalTime.MIDNIGHT;
        long now=0;
        long overallDur = 0;
     
        while(stopWatchPerm)
			{ 
                            
                            updateSigns();
                            if(stopwatchRunning)
                            {
                                now = System.currentTimeMillis();
                               countedTime=LocalTime.MIDNIGHT;
                                assignSigns(countedTime.plusNanos((now-start+overallDur)*1000000));
                                
                            }
                            else if(stopwatchStopped)
                            {
                                overallDur+=(now-start);
                                now=0;
                                start=0;
                            }
                            else
                            {
                                overallDur=0;
                                countedTime=LocalTime.MIDNIGHT;
                               assignSigns(displayedTime);
                            }
                            
                            displaySigns();
                        
            try {
                Thread.sleep(16);
            } catch (InterruptedException ex) {
                Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
            }
			}
                        
		 }
   });
   t.start();
        
    }
    
    /**
     * This method sets color of enabled panels on sevensegment displays.
     * @param paint Color you want your enabled panels to be.
     * 
     * 
     */
    
    public void setPrimaryColor(Color paint)
    {
        alfa.setPrimaryColor(paint);
        colorRefresh();
    }
    
    /**
     * This method sets color of disabled panels on sevensegment displays.
     * @param paint Color you want your disabled panels to be.
     * 
     * 
     */
    
    public void setSecondaryColor(Color paint)
    {
        alfa.setSecondaryColor(paint);
        colorRefresh();
    }
    
    /**
     * This method returns color of enabled panels.
     * @return Java.AWT.color
     * 
     * 
     */
    
    public Color getPrimaryColor()
    {
       return alfa.getPrimaryColor();
    };
    
    /**
     * This method returns color of disabled panels.
     * @return Java.AWT.color
     * 
     * 
     */
    
    public Color getSecondaryColor()
    {
       return alfa.getSecondaryColor();
    };
    
    
    private void colorRefresh()
    {
     for(int i=-1;i<=9;i++)
                    {
            try {
                alfa.createDigit(i);
            } catch (IOException ex) {
                Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
            }
                    }
       colorChanged=true;
    }
    
    /**
     * This method sets new dimensions of clock panel. It's basically resizing it.
     * @param newWidth New width of clock panel
     * @param newHeight New Height of clock panel
     */
  
    public void setClockSize(int newWidth, int newHeight)
    {
        
        
        switch(panel.getComponentCount())
        {
            case 2:
                this.digitWidth = newWidth/2;
                break;
            case 5:
                this.digitWidth = (int) (newWidth*0.23);
                this.dotWidth = (int) (newWidth*0.08);
                break;
            case 8:    
                this.digitWidth = (int) (newWidth*0.15);
                this.dotWidth = (int) (newWidth*0.05);
                break;
            case 12:
                this.digitWidth = (int) (newWidth*0.1);
                this.dotWidth = (int) (newWidth*0.034);
                break;
                
        }
        
        this.digitHeight = newHeight;
        this.resized=true;
    }
    
    private void displaySigns(){
        dig1.setIcon((Icon) numbers.get(sec1));
            dig2.setIcon((Icon) numbers.get(sec0));
            dig3.setIcon((Icon) numbers.get(min1));
            dig4.setIcon((Icon) numbers.get(min0));
            dig5.setIcon((Icon) numbers.get(hour1));
            dig6.setIcon((Icon) numbers.get(hour0));
            digM2.setIcon((Icon) numbers.get(mil2));
            digM1.setIcon((Icon) numbers.get(mil1));
            digM0.setIcon((Icon) numbers.get(mil0));
            dots.setIcon(dotsAr[sec1%2]);
            dots2.setIcon(dotsAr[sec1%2]);
            dots3.setIcon(dotsAr[sec1%2]);
            panel.repaint();
    };
    
    private void updateSigns(){
        if(colorChanged || resized)
                            {
                                try {
                                    numbers.clear();
                                    
                                    dotsAr[0]= new ImageIcon(ImageIO.read(new File("digits"+File.separator+"dots2.png")));
                                    image = dotsAr[0].getImage().getScaledInstance(dotWidth, digitHeight, Image.SCALE_SMOOTH);
                                    dotsAr[0]=new ImageIcon(image);
                                    dotsAr[1]= new ImageIcon(ImageIO.read(new File("digits"+File.separator+"dots1.png")));
                                    image = dotsAr[1].getImage().getScaledInstance(dotWidth, digitHeight, Image.SCALE_SMOOTH);
                                    dotsAr[1]=new ImageIcon(image);
                                    
                                    for(int i=0;i<=9;i++)
                                    {
                                        image = new ImageIcon(ImageIO.read(new File("digits"+File.separator+i+".png"))).getImage().getScaledInstance(digitWidth, digitHeight, Image.SCALE_SMOOTH);
                                         numbers.add(i, new ImageIcon(image));
                                        
                                        }
                                      } catch (IOException ex) {
                                    Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
            resized=false;
            colorChanged=false;
    };
    
    private void assignSigns(LocalTime time){
        sec0 = time.getSecond()/10;
            sec1 = time.getSecond()%10;
            hour0 = time.getHour()/10;
            hour1 = time.getHour()%10;
            min0 = time.getMinute()/10;
            min1 = time.getMinute()%10;
            mil2 = time.getNano()/100000000;
            mil1 = (time.getNano()/10000000)%10;
            mil0 = (time.getNano()/1000000)%10;
    }
    
    
    /**
     * This method sets new format of displayed time. There are three available formats:
     * "HH:MM" - hours and minutes
     * 
     * "HH:MM:SS" - hours, minutes and seconds
     * 
     * "HH:MM:SS:mmm" - hours, minutes, seconds and millis
     * 
     * @param format New format of clock/timer/stopwatch
     */
    
    public void setClockFormat(String format)
    {
        switch(format)
        {
            case "HH":
                panel.removeAll();
                panel.add(dig6);
                panel.add(dig5);
                panel.repaint();
                resized=true;
                break;
            case "HH:MM":
                panel.removeAll();
                panel.add(dig6);
                panel.add(dig5);
                panel.add(dots2);
                panel.add(dig4);
                panel.add(dig3);
                panel.repaint();
                resized=true;
                break;
                
            case "HH:MM:SS":
                    panel.removeAll();
                panel.add(dig6);
                panel.add(dig5);
                panel.add(dots2);
                panel.add(dig4);
                panel.add(dig3);
                panel.add(dots);
                panel.add(dig2);
                panel.add(dig1);
                panel.repaint();
                resized=true;
                break;
            case "HH:MM:SS:mmm":
                   panel.removeAll();
                panel.add(dig6);
                panel.add(dig5);
                panel.add(dots2);
                panel.add(dig4);
                panel.add(dig3);
                panel.add(dots);
                panel.add(dig2);
                panel.add(dig1);
                panel.add(dots3);
                panel.add(digM2);
                panel.add(digM1);
                panel.add(digM0);
                panel.repaint();
                resized=true;
                break;
            default:
                
                break;
        }
    }
    
    /**
     * This method starts counting time with stopwatch.
     */
    
    public void stopwatchStart()
    {
        
        start = System.currentTimeMillis();
        stopwatchRunning = true;
        stopwatchStopped = false;
    }
    
    /**
     * This method pauses couting time with stopwatch and displays measured time. After using it, if you use stopwatchStart() method,
     * stopwatch continues counting.
     */
    
    public void stopwatchPause(){
        stopwatchRunning=false;
        stopwatchStopped = true;
    }
    
    /**
     * This method resets stopwatch and prepares it for next counting.
     */
    
    public void stopwatchStop()
    {
        start = 0;
        stopwatchRunning=false;
        stopwatchStopped = false;
    }

}
