#===============================================================================
# An *explicit waits* is code you define to wait for a certain condition to 
# occur before proceeding further in the code. The worst case of this is 
# time.sleep(), which sets the condition to an exact time period to wait. 
# *WebDriverWait* in combination with ExpectedConditon is one way to write 
# code that will wait only as long as required.
#===============================================================================
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

driver=webdriver.Firefox()
driver.get("https://www.google.co.in")

try:
    # This waits up to 10s before throwing a exception if the ExpectedConditon
    # is not satisfied. However, if it finds the element, 0-10s will be return.
    WebDriverWait(driver, 2).until(
                EC.presence_of_element_located((By.ID, "element"))
                )
except:
    print('Error:')
    