package org.ani.springDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;

public class Circle implements Shape, ApplicationEventPublisherAware {

    private Point centre;
    private ApplicationEventPublisher publisher;
    @Autowired
    private MessageSource messageSource;


    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public Point getCentre() {
        return centre;
    }

    public void setCentre(Point centre) {
        this.centre = centre;
    }

    public void draw() {
        DrawEvent drawEvent = new DrawEvent(this);
        publisher.publishEvent(drawEvent);
        System.out.println(this.messageSource.getMessage("draw.circle", new Object[]{this.centre.getX(), this.centre.getY()}, "Nope", null));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }
}
