package SeleniumMentoringAhmet.SeleniumInterviewQuestion;

public class InterviewQuestions {
    /*
    1)What are the advantages and disadvantages of Selenium
    Advantages:Free open sources
               *It supports multiple languages(java,javaScriptruby,phyton C sharp)
               *Big community
               *It supports multiBrowsers(chrome, safari, internet Explorer,firefox)
    Disadvantages: *captcha,pictures,finger printsetc.. cannot be automated by Selenium
                   *There is not direct call for the selenium since it is open-source
                   *It only automates the web applications.

     2)What types of testing can you automate with Selenium?
     *Smoke Test
     *Regression Test
     *Functional Test(positive-negative UI)

    3)What are the test types we do not automate with Selenium?
    *Performance Testing
    *Manual Testing(ad Hoc--Monkey Testing)
    *Load Testing
    *Stress Testing


   4)What is locator and what are the locator types ? ******

    Locator is a way of finding the web element in the Dom.Locator types are :
    *XPATH
    *ID
    *TAGNAME
    *CLASSNAME
    *LINKTEXT
    *PARTIALLINKTEXT
    *CSS
    *NAME

    5)HOW DO YOU HANDLE DYNAMIC ELEMENTS?

    *In my course I faced many dynamic elements and i used different ways to handle with

    *I used parent-child-siblings(XPATH) to locate the elements *******
    * I went with different ATTRIBUTE to locate the elements**********


    6) Difference Between close() and quit() ?
        CLOSE: it specifically closes the window that you are currently working on.
        QUIT: it specifically closes the whole browser.It means it closes all of the windows.

    7)Difference Between navigate to() and get()?
        Navigateto : it doesnt wait web elements(page) to be loaded.
                    *it has some methods(forward, back, refresh
        get : it waits the web elements(page) to be loaded.
                    *it doesn't have methods

    8)WHAT IS XPATH?
        *Xpath is used to find the location of the elements on a webPage using HTML structure.
        *There are two types of XPATH:
        - Absolute XPATH:it goes from parent to child
        -Relative XPATH:it goes directly to the element location.

    9)What is the difference between Absolute and Relative Xpath?
    - Absolute XPATH:it goes from parent to child
    -Absolute XPATH:it has / (single slash) before XPATH structure
    - Absolute XPATH:Synthax is different
        -Relative XPATH:it goes directly to the element location.
         -Relative XPATH:it has // (double slash) before XPATH structure
         -Relative XPATH:Synthax is different

     10) How to handle static drop down menus?

     I would definitely check the tag of the location.
        *If the tag is select --> I use select CLASS  Select select = new Select(webelement)
        *if the tag is not select --> i use locators to locate the elements
        *I can also use ACTIONS CLASS to handle the drop downs. **** (movetoElement)

     11) WHAT ARE THE METHODS OF SELECT ?

       Select class is really useful to locate the elements
       * I can locate the elements with
       *SelectByVisibleText
       *SelectByIndex
       *SelectByValue

      12)What kind of exceptions did you face in Selenium?

      *NoSuchElementException ******
      *StaleElementReference Exception *******
      *NoSuchWindow Exception
      *NoSuchFrame Exception

      13) In what condition do you get StaleElementReference Exception?

      *Once the element is not there anymore.
      *Navigate to the another page.

       *****I CAN HANDLE WITH (refreshing the website  or reinitiliaze the driver)

      14)How do you handle alerts?

      *Operation System Alert :I cannot handle it directly. I need to use ROBOT
      Class to handle it.
      *HTML Alert :I just need to find the element Click the Button you want.
      *JavaScript(Browser) Alert : Alert Class

       15) FOR THE ALERT Interface WHAT KIND OF METHODS DO YOU KNOW?
       *Alert alert= driver.switchto.Alert()
       *Accept --> ok
       *Dismiss--> cancel
       *sendkeys() -- > sendkeys
       *getText()-->get the text

       16) What do you know about iframe(Frame)? Can you tell me the type that you used before ?
       and How do you handle the iframe?
       Different Types: Here is the scenario we have a website and I would like to get the text of price
       from products. all xpath is correct and there is problem with attribute as well. BUT i cannot
       get it. What do you think the reasons could be?

       ** The reason could be the Iframe,so I basically go to the website and in the dom I just
       search for the iframe.
       ??check the exception ???

       *iframe is the html inside of the another html>?
       *driver.switchto().frame(1)
       ******* driver.switcht().defaultContent() ************
       *driver.switchto()frame(2)
       *** if you have multiple iframes into each other. Then I should use
       driver.switchto()ParentFrame()

       17) What do you know about ACTIONS CLASS?

       *Actions class is really usefull to handle some issues in my project since I use some
       actions class methods. Some of the important ones are :
       *SendKeys
       *DoubleClick
       *ClickAndHold
       *DragAndDrop
       *MoveToElements
       *ContextClick(rightClick)
       *Click

       Select select = new Select(WebElement);--> select tagname
       Actions action = new Actions(driver); --> anytime

       *sdsds.click.PERFORM() --> YOU MUST SAY PERFORM AT THE END otherwise it will not execute.

       18)What is the difference between Find Element and Find Elements?

      *Find ELement--> Return single webelement
          Once the elements is not found  *** it throws the NoSUchElement Exception


      *Find Elements--> return the list of the elements
            You can access the elements by using the index number
            *Once the elements is not found ** it doesn't throw any exception but it returns
            EMPTY LIST.

       19) Difference between isDisplayed? isEnabled? and IsSelected ?
       *IsDisplayed -- >it displayeds the elements it is VISIBLE or not
       *isEnabled --> the elements is enabled or not
       *IsSelected -->the elements is selected or not.

       20)what is the difference between check box and radio button?

        * Selected and checkbox mentally is similary but the difference is you can only
        choose one radio button option
        *For the selected you can choose as many as you want.


        21) How do you switch the windows (2 windows) from one to another ?

        I switch the windows by using driver.switchto().window(id) -->

        String mainWindow = driver.getWindowHandle() -- >it returns String "id"

        Set<String> ids = driver.getWindowHandles()--> it returns the set of the ids
        ********
        for(String id : ids){  facebook page (id 12345 and twitter page (1234567)
        if(!id.equals(mainWindow){
        driver.switchto().window

        }

        for(String id : ids){  facebook page (id 12345 and twitter page (1234567), ebay page (2131253)
         // driver.switchto.window.id
        if(!driver.getTitle.equals(ebayPage){
            driver.switchto.window.id

        }









        22)How do you switch the multiple windows(more than 2) from one to another?


















     */
}
