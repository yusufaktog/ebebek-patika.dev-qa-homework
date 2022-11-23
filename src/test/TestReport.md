### Error Encountered

---


## ERROR 

* Error Message: 'Entry Not Found'
* Error Cause: 'Clicking Increase Button right after clicking delete product button'
* Description: 'Trying to increase number of product added to chart, when it is actually not in chart anymore'


## Logical Error

* Error Message: 'None'
* Steps:
    * Add at least 2 products to chart
    * Click the delete button with the trash icon and right after clicking it, click increase button rapidly
    * The topmost product will disappear but the number will be oddly shifted to the product below
* Description: 'This one does not give an error but causes system to do unexpected behaviors'