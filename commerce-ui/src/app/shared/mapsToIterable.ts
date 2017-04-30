import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'mapToIterable'
})

export class MapToIterable {
  transform(map: Map<String,Object[]>, args?: any[]): Object[] {
    var iterable = new Array<Object>();
    if (map !== undefined) {
      map.forEach((value: Object[], key: string) => {
        iterable.push({key: key, value: value});
      });
      return iterable;
    }
  }

}

