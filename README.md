[![Contributors][contributors-shield]][contributors-url]

<!-- PROJECT LOGO -->
<br />
<div align="center">
<p align="center">
<a href="https://github.com/CombatWombatZockchster/HackaTum-SusOp">
<img src="https://raw.githubusercontent.com/CombatWombatZockchster/HackaTum-SusOp/main/SusOp/resources/Logo_Wide%400.7x.png" alt="Logo" width="120" height="120">

<h3 align="center"> Susop | HackaTUM 2021 </h3>
</a>
<p align="center">
Susop means two things: Sustainabilty and Optimization
<br />
<a href="https://github.com/CombatWombatZockchster/HackaTum-SusOp"><strong>Explore the project!»</strong></a>
    <br />
  </p>
</p>
</div>

## Inspiration

Nowadays "Always-On" Devices have higher numbers than ever before, with those and other devices we just dont turn off we consume a lot of unused power everyday. Many People arent even aware of these Devices in their Home, and even if they are it is often hard to visualize the kind of Impact, a PC that is never turned off may have.

Reducing unnecessary Power Consumption is something that everyone can unintrusively introduce into your Routine that can highly impact CO2 Emissions over time.

We want to help Consumers and Companies by providing an easy tool to monitor activity of these devices and visualize the footpring they really have.

## What it does

Susop provides a simple User Interface that monitors Activity in your Network, classifies devices and calculates Energy Usage and the resulting CO2 Emission from statistical data by the Umweltbundesamt.

In the future it will run decentralized, sharing any old monitoring data through the network to newer devices, so we can reduce even the impact the monitoring would have.

## How we built it

First of all we researched Power Consumption of HouseHold Devices that are connected to your Network and during that we also looked into the actual CO2 Emissions we get from our Energy Consumption.
After we gathered that Data we began to build our App using Java, there we created a DeviceScanner and Recognizer for our Network, with which we then monitored our Network Activity and UpTime of these Devices. We used this Data with Average Wattage Data to calculate Emissions and Power Consumption.

The UI was created using JavaSwing concurrently, here we wanted to provide a very simple but visual tool for the User.

## Challenges we ran into

Getting all the Devices from your Network and correctly classifying them can be pretty hard, especially if the device owner wants to only share limited Data with you. We tried to classify the Devices we tested with, as well as possible but sometimes you really only have an IP-Adress and nothing else and then it is almost impossible to get a correct Wattage Estimation.
We also had Problems with getting and identifying the different Mac Addresses of Devices, as this was the original Plan to estimate Power Consumption. Sadly even if we would have finished the implementation of this, we would at most have been able to gather Information about the Company from the Mac Address and not necessarily the Device Type itself.

## Accomplishments that we're proud of

We created an easy to understand Network Monitoring Tool, that could help lower CO2 waste. We created a project that could be easily ported to different Devices to further reduce the Impact of our Network.

## What we learned

We learned a lot about Networks and how we can interact within our local Networks. Additionally we realized how much unnecessary Power was drawn by simple and small devices in our own home and how much energy some devices really use.

## What's next for Susop

In the Future Susop would love to further develope the decentralized communication we started building during the hackathon but couldnt finish due to Time Constraints. We would also love to port it to different Devices creating an even better and closer Network. 
If possible wed also love to get more specific and accurate Stats about energy consumption, either from the devices themselves, through running our software, or from SmartHome Integration.

## Last Words

Until then! Hear you soon and maybe watch your favourite Show on your Phone or Laptop, instead of your TV next time.

And to the companies, you really can turn off the Lights and big Presentation Screens during the weekend if no-one is working ;)
And if youre unsure about the impact that has, try Susop!

(UI-Icons from flaticon.com)

<!-- MARKDOWN LINKS & IMAGES -->
[contributors-shield]: https://img.shields.io/github/contributors/CombatWombatZockchster/HackaTum-SusOp
[contributors-url]: https://github.com/CombatWombatZockchster/HackaTum-SusOp/graphs/contributors
