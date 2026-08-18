

Entities

Bill 
id
List<CartItem>

User 
id
name



CartItem
id
price
quantity
category



ItemCategory - > Electronics, HomeAppliances, Clothing


Discount
int value;
int amount;
DiscountStrategy discountStartegy;


PercentageDiscount extends Discount
applyDiscount(Discount)

FlatDiscount extends Discount
applyDiscount

ItemCategoryDiscount extends Discount
applyDiscount


Interfaces

BillingService

generateBill(Bill, List<Discount> discounts)


DiscountStrategy
calculateDiscount()


PercentageDiscountStrategy


FlatDiscountStrategy


ItemCategoryDiscountStrategy


Result --

# Get your inputs and outputs clear in the design itself and complete methods and fields
# Write 4-6 sections and populate in the beginning only and course corecct back and forth 
entities, enums, interfaces, stratigies, factory,  orchestrator , impl 
# Keep caller simple without map take list only and pass everything to strategy and keep service as simple 
as possible 





