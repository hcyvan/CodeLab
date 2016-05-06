from selenium import webdriver
import time
def calculate_implicit_wait_time(driver, wait_value, element):
    if wait_value:
        driver.implicitly_wait(wait_value)
    now=time.time()
    try:
        myelement=driver.find_element_by_id(element)
    except:
        pass
    print(str(int(time.time()-now))+'--Seconds')
    
driver=webdriver.Firefox()
driver.get("https://www.google.co.in")

calculate_implicit_wait_time(driver, 30, 'element')
